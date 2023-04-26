import axios from "../api/request";

function getRecently(userId: string|number) {
    return new Promise((reslove,reject) => {
        axios.get("/api/recently/" + userId).then(async res => {
            let recentlyList: IArtists[] = []
            let resList:IRead[] = res.data.value
            for (let item of resList){
                let res = await axios.get("artists/id/" + item.artistsId)
                recentlyList.push(res.data)
            }
            reslove(recentlyList)
        }).catch(err => {
            reject(err)
        })
    })
}

export default getRecently