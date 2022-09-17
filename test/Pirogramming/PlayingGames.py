import string
import random

class Player:
    def __init__(self, name, hp, damage, correct_alp):
      self.name = name      # 이름
      self.hp = hp          # 생명력
      self.damage = damage  # 데미지
      self.correct_alp = 0  # 알파벳 맞춘 횟수


class Game:

    def __init__(self):
      self.player = []  # 캐릭터의 목록. start_game()에서 생성
      self.user_character = ""  # 사용자가 선택한 캐릭터
      self.remain_alp = list(string.ascii_uppercase)  # 남은 알파벳
      self.cur_string = ["_"] * 10  # 현재까지의 글자상태를 저장
      self.talked_alp = [] # 이미 말한 알파벳
      self.answer_string = ""  # 랜덤 10글자 단어

    def start_game(self):

      self.player.append(Player("김용빈", 50, 20, 0))
      self.player.append(Player("김규리", 70, 25, 0))
      self.player.append(Player("이승아", 80, 30, 0))
      self.player.append(Player("윤석현", 90, 35, 0))
      
      # TODO 1-(1)

      user_select=int(input())-1 #숫자 입력받기, index로 써야하니 -1
      self.user_character=self.player[user_select].name # name만 가져오기


      # TODO 1-(2) 

      for i in range(10): #10번 반복
        random_number=random.randint(0,len(self.remain_alp)-1) #랜덤 정수 생성, 범위 :0~25
        self.answer_string+=self.remain_alp[random_number] #인덱싱으로 self.answer_string에 한 글자 저장

      
      
    def sort_data(self, i):        

      # TODO 2 
      
      if i == 1:#Round 1
        self.player.sort(key = lambda x : x.name) #name 내림차순 정렬

      else:#Round 2,3
        self.player.sort(key = lambda x : (-x.hp, x.name)) #hp 오름차순, name 내림차순 정렬
      
    def play_game(self):

      print(
          f"게임은 {self.player[0].name},{self.player[1].name},{self.player[2].name},{self.player[3].name} 순으로 진행됩니다.\n")

      for i in range(4):

          if self.player[i].name == self.user_character:
              print("***** 내 캐릭터 *****")
              
          else:
              print(f"***** {i+1} 캐릭터 *****")
          
          print(f"이름: {self.player[i].name} (HP: {self.player[i].hp})")

          # TODO 3-(1)

          while True:

            #알파벳 랜덤 뽑기
            random_number= random.randint(0,len(self.remain_alp)-1) #랜덤 정수 생성, 범위 :0~25
            select_alphabet=self.remain_alp[random_number]#인덱싱으로 알파벳 하나 뽑기

            if select_alphabet in self.talked_alp: #랜덤하게 뽑은 알파벳을 다른 누군가 이미 말했다면 다시 뽑기
              pass

            elif select_alphabet not in self.talked_alp: #랜덤하게 뽑은 알파벳이 처음 나온 거라면 진행
              self.talked_alp.append(select_alphabet)  #랜덤하게 뽑은 알파벳 말한 알파벳 리스트에 추가
              self.remain_alp.remove(select_alphabet)  #랜덤하게 뽑은 알파벳을 알파벳 리스트에서 삭제하기
              print('선택 알파벳 :',select_alphabet)
              break
        
          # TODO 3-(2) 

          if select_alphabet in self.answer_string: #랜덤하게 뽑은 알파벳 정답에 있나 확인

            count_alp=self.answer_string.count(select_alphabet) #정답에 알파벳 몇 개 있나 확인

            for k in range(count_alp): #알파벳 개수만큼 반복
              index_number=self.answer_string.index(select_alphabet) #알파벳의 인덱스 추출
              self.cur_string[index_number]=select_alphabet #정답 알파벳 표현

            print("***** 맞았습니다 ᵔεᵔ  *****")
            correct=''.join(self.cur_string) #list 문자열 출력
            print(correct)

            #플레이어별 점수 집계
            self.player[i].correct_alp+=1

            
          # TODO 3-(3)

          elif select_alphabet not in self.answer_string:#랜덤하게 뽑은 알파벳 정답에 있나 확인
            
            #hp에서 damage 빼주기
            self.player[i].hp-=self.player[i].damage

            #출력
            print("***** 틀렸습니다 (ﾟ⊿ﾟ)  ******")
            print(f"{self.player[i].name}은 틀렸기 때문에 HP가 {self.player[i].hp}남았습니다.")

          # Write code here..
          ##### END OF TODO 3-(3)(문제와 본 라인 사이에 코드를 작성하세요.) #####
          

    def game_result(self):


      print("\n\n******************* 게임이 끝났습니다 *******************")

      # TODO 4-(1)

      print("=============================")
      print("     게임 순위 - 생명력")
      print("=============================")

      self.player.sort(key = lambda x : (-x.hp, x.name)) #hp 오름차순, name 내림차순

      for i in range(4):
        if self.player[i].name == self.user_character: #내 캐릭터인 경우 * 붙이기

          if self.player[i].hp > 0: #사망자 확인, 사망 표시
            print(f'{i+1}등: *{self.player[i].name}* (HP: {self.player[i].hp})') 
          elif self.player[i].hp <= 0:
            print(f'{i+1}등: *{self.player[i].name}* (사망)')

        elif self.player[i].name != self.user_character: #내 캐릭터가 아닌 경우

            if self.player[i].hp > 0: #사망자 확인, 사망 표시
              print(f'{i+1}등: {self.player[i].name} (HP: {self.player[i].hp})')
            elif self.player[i].hp <= 0:
              print(f'{i+1}등: {self.player[i].name} (사망)')

      

      # TODO 4-(2)

      print("=============================")
      print(" 게임 순위 - 알파벳 맞춘 횟수")
      print("=============================")

      self.player.sort(key = lambda x : (-x.correct_alp, x.name)) #correct_alp 오름차순, name 내림차순
      for i in range(4):
        if self.player[i].name == self.user_character: #내 캐릭터 확인
          print(f'{i+1}등: *{self.player[i].name}* {self.player[i].correct_alp}회') #내 캐릭터에 * 붙이기
        else:  
          print(f'{i+1}등: {self.player[i].name} {self.player[i].correct_alp}회')
    

    def game(self):

      self.start_game()

      print("******************* 게임 시작 *******************\n")

      for i in range(1, 4):
          print("===========================")
          print(f"     ROUND {i} - START")
          print("===========================")

          self.sort_data(i)
          self.play_game()

          print("===========================")
          print(f"     ROUND {i} - END")
          print("===========================")

      self.game_result()


if __name__ == '__main__':

    game = Game()
    game.game()