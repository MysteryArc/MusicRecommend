import string
import pymysql
import secrets # import package

db = pymysql.connect(
    host="localhost",
    user="root",
    password="123456",
    database="music_recommend"
)

cursor = db.cursor() #创建游标对象

for i in range(13785):
    num = 6
    res = ''.join(secrets.choice(string.ascii_letters + string.digits) for x in range(num))
    inputsql = "UPDATE music_recommend.user t SET t.name = '%s' WHERE t.id = %d;" %(res,i)
    db.commit()
    cursor.execute(inputsql)
    print("input %d" %(i))