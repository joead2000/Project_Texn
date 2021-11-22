import { urlencoded, json }  from 'express';
import express = require('express');
import { postgres } from './postgres';

export async function create() {
    const router = express.Router();
    router.use(urlencoded({ extended: false }));
    const app = express()
    app.use(json())

    app.get('/test', (req, res) => {
        res.send('Hello World I am running locally');
    });
    app.route('/login').post((req: express.Request, res: express.Response) => {
        const username = req.body.username
        const password = req.body.password
        postgres.getInstance.login(username, password, () => {
            res.status(200).send(JSON.stringify({ result: 'fail' }));
        }, () => {
            res.status(200).send(JSON.stringify({ result: 'success' }));
        })
    });
    app.route('/registration').post((req: express.Request, res: express.Response) => {
        const username = req.body.username
        const email = req.body.email
        const password = req.body.password
        postgres.getInstance.register(email, username, password, () => {
            res.status(200).send(JSON.stringify({ result: 'fail' }));
        }, () => {
            res.status(200).send(JSON.stringify({ result: 'success' }));
        })
    });

    app.listen(process.env.WEBSERVER_PORT, () => {  console.log(`Server listening on http://localhost:${process.env.WEBSERVER_PORT}`); })
}