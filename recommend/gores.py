import pymysql
import time
from gorse import Gorse

db = pymysql.connect(
    host="localhost",
    user="root",
    password="123456",
    database="music_recommend"
)

cursor = db.cursor() #创建游标对象

#用户查询
sql = "select id from user"
cursor.execute(sql)
alluser = cursor.fetchall() #获取全部数据
userres = []
for i in alluser:
    userres.append(
        {
            "UserId": str(i[0])
        }
    )

#音乐查询
artistsres = []
tags = []
sql = "select"


def main():
    #create
    client = Gorse('http://127.0.0.1:8087', '')

    for i in userres:
        client.insert_user(i)

    

main()