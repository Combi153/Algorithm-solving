def solution(my_string, is_suffix)
  if my_string.reverse.start_with?(is_suffix.reverse)
    1
  else
    0
  end
end
