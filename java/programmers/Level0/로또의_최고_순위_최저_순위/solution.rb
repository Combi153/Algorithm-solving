require 'set'

def get_rank(count)
  if count == 6
    1
  elsif count == 5
    2
  elsif count == 4
    3
  elsif count == 3
    4
  elsif count == 2
    5
  else
    6
  end
end

def solution(lottos, win_nums)
  zero_count = lottos.select.count { |num|
    num == 0
  }
  same_count = (lottos.to_set & win_nums.to_set).count
  total_count = zero_count + same_count
  answer = Array.new
  answer << get_rank(total_count)
  answer << get_rank(same_count)
  answer
end
