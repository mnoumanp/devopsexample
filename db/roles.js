db.getCollection('list-values').insertMany([
    {
    	"name" : "USER_ROLES",
        "fieldName" : "userRole",
        "value" : "Admin",
        "code" : "ADMIN"
    }, {
    	"name" : "USER_ROLES",
        "fieldName" : "userRole",
        "value" : "Technician",
        "code" : "TECHNICIAN"
    }, {
    	"name" : "USER_ROLES",
        "fieldName" : "userRole",
        "value" : "Receptionist",
        "code" : "RECEPTIONIST"
    }, {
    	"name" : "USER_ROLES",
        "fieldName" : "userRole",
        "value" : "Spare Part Manager",
        "code" : "SPARE_PART_MANAGER"
    }
]);
