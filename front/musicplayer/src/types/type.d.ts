interface IArtists{
    cloudId: number,
    name: string,
    singer: string,
    picUrl: string,
    album: string,
    playUrl: string,
    id: number
}

interface IPopular{
    Id: string,
    Score: number
}

interface IBanner{
    imageUrl: string,
    targetId: number
}

interface IMenu {
    name: string,
    path: string,
    key: string,
    icon?: any
}

interface IMenuList{
    name: string,
    menus: IMenu[]
}

interface IRead{
    userId: any,
    artistsId: any,
    weight: number,
    timestamp: number
}

interface ILove{
    userId: any,
    artistsId: any,
    timestamp: number
}