from gorse import Gorse

def main():
    #create
    client = Gorse('http://127.0.0.1:8087', '')

    for i in range(9832, 20000):
        client.delete_item(i)
        print("delete {}".format(i))

main()