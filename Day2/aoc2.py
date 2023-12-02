import re

with open("input.txt", "r") as file:
    lines = file.readlines()
    check = True
    res = 0
    # for each line in input
    for line in lines:
        check = True
        temp = line[:8]
        id = re.findall(r'\d+', temp)[0]
        id = int(id)
        line = line[7:]
        row = line.split(";")
        arr = [0] * 3
        # for each ;
        for words in row:
            values = words.split(",")
            # [2 green, 3 blue, 4 red]
            arr[0] = arr[1] = arr[2] = 0
            for x in values:

                if "red" in x:
                    arr[0] = [int(i) for i in x.split() if i.isdigit()][0]
                elif "green" in x:
                    arr[1] = [int(i) for i in x.split() if i.isdigit()][0]
                elif "blue" in x:
                    arr[2] = [int(i) for i in x.split() if i.isdigit()][0]
            if arr[0] > 12 or arr[1] > 13 or arr[2] > 14:
                check = False
            print(arr)
        if check is True:
            res += id
