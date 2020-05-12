package com.example.colorgame

class User {
    var id: Int = 0
    var name: String = ""
    var points: Int = 0

    constructor(){}

    constructor(name:String, points:Int)
    {
        this.name = name
        this.points = points
    }

}