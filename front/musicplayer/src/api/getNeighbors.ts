import axios from "./request";

function getNeighbors(musicId:number|string) {
    return new Promise((reslove,reject) => {
        axios.get("http://localhost:8087/api/item/" + musicId + "/neighbors").then(async res => {
            let neighborList:IArtists[] = []
            let resList:any = []
            resList = res.data
            for (let item of resList) {
                let res = await axios.get("artists/id/" + item.Id)
                neighborList.push(res.data)
            }
            reslove(neighborList)
        }).catch(err => {
            reject(err)
        })
    })
}

export default getNeighbors