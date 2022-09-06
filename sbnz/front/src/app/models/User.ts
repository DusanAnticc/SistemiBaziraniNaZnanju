export interface User{
    id : number,
    dtype : string,
    firstName : string,
    lastName : string, 
    email : string,
    username : string,
    password : string,
    deleted : boolean,
    energyProduced : number,
	category : string,
	discount : number,
	owes : number,
    prosecuted : boolean
}