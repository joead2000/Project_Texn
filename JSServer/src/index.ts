import { postgres } from "./postgres";
import { create } from "./webserver";
import * as dotenv from "dotenv";

dotenv.config()
new postgres().connect();
create();

process.on('unhandledRejection', error => {
	console.error('Unhandled promise rejection:', error);
});
