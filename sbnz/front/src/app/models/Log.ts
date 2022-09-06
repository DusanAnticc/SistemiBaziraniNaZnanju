import { SteamMachine } from "./SteamMachine";

export interface Log {
    id: number,
	message: string,
	userName: string,
	executionTime: number,
    steamMachine: SteamMachine
}