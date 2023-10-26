// routes/auth.js

const express = require('express');
const router = express.Router();
const User = require('../models/User');
const jwt = require('jsonwebtoken');

const axios = require('axios');

const config = {
    method: 'POST',
    loginUrl: 'http://localhost:8180/auth/realms/spring-micro-main/protocol/openid-connect/token',
    registerUrl: 'http://localhost:8180/auth/admin/realms/spring-micro-main/users',
    clientId: 'spring-micro-gateway',
    clientSecret: 'bd438a26-26a6-46dd-926d-6e3d71df15e3',
    realm: 'spring-micro-main',
    loginHeaders: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    registerHeaders: {
        'Content-Type': 'application/json'
    },
}

function hashPassword(password, salt) {
    return crypto.pbkdf2Sync(password, salt, 10000, 64, 'sha512').toString('hex');
}

router.get('', async (req, res) => {
    return res.status(200).json({ message: 'All users' });
})

router.post('/keycloak', async (req, res) => {
    
    return res.status(200).json({ message: response || "Failed to fetch" });

})

// Login endpoint
router.post('/login', async (req, res) => {
    try {
        const { username, password } = req.body;

        const configg = {
            method: 'POST',
            url: 'http://127.0.0.1:8180/auth/realms/spring-micro-main/protocol/openid-connect/token',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            data: `grant_type=password&client_id=spring-micro-gateway&client_secret=bd438a26-26a6-46dd-926d-6e3d71df15e3&username=${username}&password=${password}`,
        };

        const response = await axios(configg);

        return res.status(200).json(response.data || "Failed to fetch");
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Internal Server Error' });
    }
});

// Registration endpoint
router.post('/register', async (req, res) => {
    try {
        const { email, username, password } = req.body;

        // login and get token to use in register
        const optionsLogin = {
            method: config.method,
            url: config.loginUrl,
            headers: config.loginHeaders,
            data: `grant_type=password&client_id=${config.clientId}&client_secret=${config.clientSecret}&username=dev&password=123`,
        };

        let token = '';

        await axios.request(optionsLogin).then(function (response) {
            if (response.status != 200) {
                return res.status(400).json({ message: 'Login error' });
            }
            token = response.data.access_token;
            if (!token) {
                return res.status(400).json({ message: 'Login error' });
            }
        }).catch(function (error) {
            return res.status(400).json({ message: error  });
        });

        const data = {
            "enabled": true,
            "email": email,
            "username": username,
            "credentials": [{
                "type": password,
                "value": "123",
                "temporary": false
            }]
        }

        const options = {
            method: config.method,
            url: config.registerUrl,
            headers: {...config.registerHeaders, ...{Authorization: `Bearer ${token}`}},
            data: data,
        };

        await axios.request(options).then(function (response) {
            if (response.status != 201) {
                return res.status(400).json({ message: response.error || 'Register error' });
            }
            return res.status(200).json(response.data || {message: "Registered successfully"} );
        }).catch(function (error) {
            return res.status(400).json({ message: error  });
        });
    } catch (error) {
        res.status(500).json({ message: error });
    }
});

module.exports = router;
