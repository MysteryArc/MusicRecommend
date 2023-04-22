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

export function useMenu() {
    const menus: IMenuList[] = [
        {
            name: "在线音乐",
            menus: [
                {
                    name: "推荐",
                    path: "#/recommend",
                    key: "recommend",
                    icon: ""
                },
                {
                    name: "音乐馆",
                    path: "#/show",
                    key: "show",
                    icon:""
                }
            ]
        },
        {
            name: "我的音乐",
            menus: [
                {
                    name: "我喜欢",
                    path: "#/love",
                    key: "love",
                    icon: ""
                },
                {
                    name: "最近播放",
                    path: "#/recently",
                    key: "recently",
                    icon: ""
                }
            ]
        }
    ]
    return menus
}