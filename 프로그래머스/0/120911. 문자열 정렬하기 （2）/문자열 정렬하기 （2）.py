def solution(my_string):
    answer = ''
    answer = my_string.lower()
    answer = sorted(answer)
    return "".join(answer)