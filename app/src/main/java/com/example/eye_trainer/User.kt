package com.example.eye_trainer

class User {
    var name: String = ""
    var score: Int = 0
    var id: Int = 0

    constructor(name: String, score: Int){
        this.name = name
        this.score = score
    }
    constructor(){}
}