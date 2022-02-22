// Ajax, callback, http requests

class Request {
    constructor() {
        // console.log(this) // this => Request
        this.xhr = new XMLHttpRequest()
    }
    // Get Request
    get(url, callback) {
        this.xhr.open("GET", url)
        // console.log(this) // this =>Request

        // this.xhr.onload = function () {
        //     // console.log(this) // this => xhr = XMLHttpRequest
        //     if(this.status === 200){
        //         console.log(this.responseText)
        //     }
        // }
        this.xhr.onload = () => {
            // console.log(this) // this => Request
            if (this.xhr.status === 200) {
                callback(null, this.xhr.responseText)
            }
            else {
                // hata durumu
                callback("Get Request: Herhangi bir hata olustu", null)
            }
        }

        this.xhr.send()
    }
    // Post Request
    post(url, data, callback) {
        this.xhr.open("POST", url)
        this.xhr.setRequestHeader("Content-type", "application/json") // JSON Verisi gonderecegimizi soyluyoruz

        this.xhr.onload = () => {
            if(this.xhr.status === 201){
                callback(null, this.xhr.responseText)
            }
            else{
                callback("Post Request: Herhangi bir hata olustu", null)
            }
        }

        this.xhr.send(JSON.stringify(data))
    }
    put(url, data, callback) {
        this.xhr.open("PUT", url)
        this.xhr.setRequestHeader("Content-type", "application/json") // JSON Verisi gonderecegimizi soyluyoruz

        this.xhr.onload = () => {
            if(this.xhr.status === 200){
                callback(null, this.xhr.responseText)
            }
            else{
                callback("Put Request: Herhangi bir hata olustu", null)
            }
        }

        this.xhr.send(JSON.stringify(data))
    }
    delete(url, callback) {
        this.xhr.open("DELETE", url)
        
        this.xhr.onload = () => {
            if (this.xhr.status === 200) {
                callback(null, "Veri silme islemi basarili...")
            }
            else {
                callback("Delete Request: Herhangi bir hata olustu", null)
            }
        }

        this.xhr.send()
    }
}

const request = new Request()

// request.get("https://jsonplaceholder.typicode.com/albums", function (error, response) {
//     if(error === null){
//         // basarili
//         console.log(response)
//     }
//     else{
//         // hata
//         console.log(error)
//     }
// })

// request.get("https://jsonplaceholder.typicode.com/albums/51", function (error, response) {
//     if (error === null) {
//         // basarili
//         console.log(response)
//     }
//     else {
//         // hata
//         console.log(error)
//     }
// })

// let album = {userId:2, title:"Post deneme baslik"}
// request.post("https://jsonplaceholder.typicode.com/albums", album, function (error, response) {
//     if(error === null){
//         console.log(response)
//     }
//     else{
//         console.log(error)
//     }
// })

// let album = {userId:143, title:"Put deneme baslik"}
// request.put("https://jsonplaceholder.typicode.com/albums/10", album, function (error, response) {
//     if(error === null){
//         console.log(response)
//     }
//     else{
//         console.log(error)
//     }
// })

request.delete("https://jsonplaceholder.typicode.com/albums/23", function (error, response) {
    if(error === null){
        console.log(response)
    }
    else{
        console.log(error)
    }
})

