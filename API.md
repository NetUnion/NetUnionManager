# API Document

## Device

The device table has five columns: id, device_type, manage_ip, name, rack_no. The column id is auto-incremented, column name is not nullable and should be unique.

1. Get the infomation of all devices
   - GET /device
   - Return a list of all devices in json format.
2. Get the infomation of a certain device
   - GET /device/{name}
   - Return the infomation of the certain device in json format.
   - Error: `{"error": "NO DEVICE"}` if the device does not exist.
3. Add a new device
   - POST /device/add
   - BODY: in json format, the following fields are required: device_type, manage_ip, name, rack_no. For example: ` { "device_type": "", "manage_ip": "", "name": "QSH.SW1", "rack_no": "" } `
   - Return the infomation of the new device in json format.
   - Error: `{"error": "DEVICE EXISTS"}` if the device already exists.
4. Delete a device
   - DELETE /device/delete/{name}
   - Return the infomation of the deleted device in json format.
   - Error: `{"error": "NO DEVICE"}` if the device does not exist.
5. Update a device's type
   - POST /device/update/type
   - BODY: in **form** data format, the following fields are required: `name`, `deviceType`.
   - Error: `{"error": "NO DEVICE"}` if the device does not exist.
6. Update a device's manage ip
   - POST /device/update/manageIp
   - BODY: in **form** data format, the following fields are required: `name`, `manageIp`.
   - Return the infomation of the updated device in json format.
   - Error: `{"error": "NO DEVICE"}` if the device does not exist.
7. Update a device's rack no
   - POST /device/update/rackNo
   - Return the infomation of the updated device in json format.
   - BODY: in **form** data format, the following fields are required: `name`, `rackNo`.
   - Error: `{"error": "NO DEVICE"}` if the device does not exist.

## Member

The member table has five columns: `id`, `name`, `student_id`, `bank_num` and p`hone_num`. The column `id` is auto-incremented, column `name` and `student_id` is not nullable and should be unique.

1. Get the infomation of all members
   - GET /member
   - Return a list of all members in json format.
2. Get the infomation of a certain member
   - GET /member/{studentId}
   - Return the infomation of the certain member in json format.
   - Error: `{"error": "NO MEMBER"}` if the member does not exist.
3. Add a new member
   - POST /member/add
   - BODY: in json format, the following fields are required: `name`, `student_id`, `bank_num`, `phone_num`. For example: ` { "name": "david", "studentId": "2020010101001", "bankNum": "", "phoneNum": "" } `
   - Return the infomation of the new member in json format.
   - Error: `{"error": "MEMBER EXISTS"}` if the member already exists.
4. Delete a member
   - DELETE /member/delete/{studentId}
   - Return the infomation of the deleted member in json format.
   - Error: `{"error": "NO MEMBER"}` if the member does not exist.
5. Update a member's bank number
   - POST /member/update/bank
   - BODY: in **form** data format, the following fields are required: `studentId`, `bankNum`.
   - Return the infomation of the updated member in json format.
6. Update a member's phone number
   - POST /member/update/phone
   - BODY: in **form** data format, the following fields are required: `studentId`, `phoneNum`.
   - Return the infomation of the updated member in json format.
   - Error: `{"error": "NO MEMBER"}` if the member does not exist.

## User

The user table has four columns: `id`, `username`, `password` and `authority`. The column `id` is auto-incremented, every column is not nullable and column `username` should be unique.

1. Get the infomation of all users
   - GET /user
   - Return a list of all users in json format.
2. Get the infomation of a certain user
   - GET /user/{username}
   - Return the infomation of the certain user in json format.
3. Add a new user
   - POST /user/add
   - BODY: in json format, the following fields are required: `username`, `password`, `authority`. For example: ` { "username": "david", "password": "123456", "authority": "admin,user" } ` The password **SHOULD NOT** be encrypted, it will be encrypted before storing in the database.
   - Return the infomation of the new user in json format.
   - Error: `{"error": "USER EXISTS"}` if the user already exists.
4. Delete a user
   - DELETE /user/delete/{username}
   - Return the infomation of the deleted user in json format.
   - Error: `{"error": "NO USER"}` if the user does not exist.
5. Update a user's authority
   - POST /user/update/authority
   - BODY: in **form** data format, the following fields are required: `username`, `authority`.
   - Return the infomation of the updated user in json format.
6. Update a user's password
   - POST /user/update/password
   - BODY: in **form** data format, the following fields are required: `username`, `oldPassword` and `newPassword`. All passowrds **SHOULD NOT** be encrypted, it will be encrypted before storing in the database and the bank end will automatically match the old password with the existed one.
   - Return `{"success": "PASSWORD CHANGED"}`.
   - Error: `{"error": "NO USER"}` if the user does not exist. `{"error": "WRONG PASSWORD"}` if the old password is wrong.

## Login

1. Main page
   - GET /index
   - Return "Welcome to NetUnion Manager!"
2. From Login
   - POST /login
   - BODY: in **form** data format, the following fields are required: `username` and `password`.
   - Return to `/index` if the login is successful by default.
3. GitHub login
   - GET /oauth2/authorization/github
   - Return to `/index` if the login is successful by default.
