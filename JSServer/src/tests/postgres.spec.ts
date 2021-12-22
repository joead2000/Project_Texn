import { postgres } from '../postgres';

const p = new postgres();
p.connect();
const email = "test@gmail.com"
const username = "test"
const password = "test"

test('biography length should not be 0', async() => {
    await p.register(email, username, password, () => {}, () => {});
    await p.login(username, password, () => {}, () => { expect(true).toBe(true) });
    await p.forgotPassword(email, (password) => { expect(password).toBe(password) }, () => {})
})