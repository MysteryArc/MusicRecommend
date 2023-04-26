import axios from "../api/request";

function getLoveList(userId: string|number) {
    return new Promise((reslove,reject) => {
        axios.get("/api/love/" + userId).then(async res => {
            let loveList: IArtists[] = []
            let resList:ILove[] = res.data.value
            for (let item of resList){
                let res = await axios.get("artists/id/" + item.artistsId)
                loveList.push(res.data)
            }
            reslove(loveList)
        }).catch(err => {
            reject(err)
        })
    })
}

export default getLoveList