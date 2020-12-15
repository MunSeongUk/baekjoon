H, M = map(int, input().split())
M = M - 45
if M < 0:
    H -= 1
    if H < 0:
        H = 24 + H
    M = 60 + M
print(f'{H} {M}')