import axios from 'axios'
import { cacheManager } from './cacheManager';

export class audioDB { 
    static getInstance: audioDB;

    constructor() {
        audioDB.getInstance = this;
    }

    request(artist: string) {
        if (!artist || artist.length <= 0) return 'invalid artist!'

        if (cacheManager.getInstance.exists(artist)) {
            return cacheManager.getInstance.get(artist);
        }

        const response = axios.get(`https://audiodb.com/api/v1/json/1/search.php?s=${artist}`)
        cacheManager.getInstance.set(artist, response + '', 8.64e+7)
        //return response.body
    }
}