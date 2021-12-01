export class cacheManager {
    static getInstance: cacheManager

    cache: { [key: string]: any } = {};

    constructor() {
        cacheManager.getInstance = this;
    }

    set(key: string, value: any, deleteTime: number = 8.64e+7 /*default - 1 hour - in ms*/) {
        this.cache[key] = value;
        setTimeout(() => {
            delete this.cache[key];
        }, deleteTime);
    }
    get(key: string) {
        return this.cache[key] || undefined;
    }
    exists(key: string) {
        return this.cache[key] !== undefined && this.cache[key] !== null;
    } 
}