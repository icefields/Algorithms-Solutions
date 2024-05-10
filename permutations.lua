
--[[ Prints permutations of the string
    str - the string 
    startI - starting index
    endI - end index
--]]
function permute(strList, startI, endI)
    if (#strList ~= endI) then return end
    if (startI == endI) then
        print(table.concat(strList))
    else
        for i = startI, endI, 1 do
            strList[startI], strList[i] = strList[i], strList[startI]
            permute(strList, startI+1, endI)
            strList[startI], strList[i] = strList[i], strList[startI]  -- backtrack      
        end
    end
end

local list = {}
local string = "ABC"
-- string:gsub(".", function(c) table.insert(list,c) end)
for i = 1, #string, 1 do
    table.insert(list,string:sub(i, i))
end
permute(list, 0, #list)

