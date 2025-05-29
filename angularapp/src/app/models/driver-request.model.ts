export interface DriverRequest {
driverRequestId:number;
userId:number;
driverId:number;
requestDate :Date;
status:string;
tripDate:Date;
timeSlot:Date;
pickupLocation:string;
dropLocation:string;
estimatedDuration:string;
paymentAmount:number;
comments:string;
actualDropTime:Date;
actualDuration:string;
actualDropDate:Date;
}
