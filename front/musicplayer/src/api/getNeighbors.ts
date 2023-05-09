import axios from "./request";

function getNeighbors(musicId:number|string) {
    return new Promise((reslove,reject) => {
        axios.get("http://localhost:8080/api/neighbors/" + musicId).then(async res => {
            let neighborList:IArtists[] = []
            neighborList = res.data.value
            reslove(neighborList)
        }).catch(err => {
            reject(err)
        })
    })
}

export default getNeighbors