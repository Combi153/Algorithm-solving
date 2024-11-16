def solution(code)
  mode = 0
  ret = ""
  (0..code.length - 1).each do |index|
    character = code[index]
    if mode == 0 and character === "1"
      mode = 1
    elsif mode == 0 and character != "1"
      ret << character if index.even?
    elsif mode == 1 and character === "1"
      mode = 0
    else
      ret << character if index.odd?
    end
  end
  ret = "EMPTY" if ret.empty?
  return ret
end
