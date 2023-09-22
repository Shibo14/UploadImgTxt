package uz.abbos.firebaseimgtxtupload

class TechData {



    var imageUrl: String = ""
    var techName: String = ""
    var techSuraName: String = ""
    var techAge: String = ""
    var techScience: String = ""
    var techPhoneNumber: String = ""

    constructor()


    constructor(
        imageUrl: String, techName: String,
        techSuraName: String, techScience: String, techAge: String, techPhoneNumber: String
    ) {
        this.imageUrl = imageUrl
        this.techName = techName
        this.techSuraName = techSuraName
        this.techAge = techAge
        this.techPhoneNumber = techPhoneNumber
        this.techScience = techScience



    }





}