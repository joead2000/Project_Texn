import { audioDB } from '../audioDB';
import { cacheManager } from '../cacheManager';

const adb = new audioDB();
new cacheManager();

test('biography length should not be 0', async() => {
  await adb.requestBiography('drake', (artist) => expect(artist.length).not.toBe(0));
})

test('album length should not be 0', async() => {
  await adb.requestAlbums('drake', (artist) => expect(artist.length).not.toBe(0))
})