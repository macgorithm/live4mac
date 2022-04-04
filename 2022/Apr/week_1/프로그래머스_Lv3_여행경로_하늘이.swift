//
//  main.swift
//  Lv3_여행경로
//
//  Created by 하늘이 on 2022/04/02.
//

import Foundation

// cur: 현재지점
// route: 현재까지의 경로
// count: 경로가 String 이라서 갯수 세기가 귀찮아서 변수로 던져줬습니다.
// endCount: 탈출조건
// dict: 티켓 (사용여부 변환을 위해서 inout)
func dfs(_ cur: String, _ route: String, _ count: Int, _ endCount: Int,
         _ dict: inout Dictionary<String, [(String, Bool)]>,
         _ answer: inout [String])  {
    if count == endCount {
        answer.append(route)
        return
    }
    
    for i in 0..<dict[cur]!.count {
        if !dict[cur]![i].1 {
            dict[cur]![i].1 = true
            let next = dict[cur]![i].0
            
            // 출발지에는 없고 도착지에만 있는 나라가 있기 때문에 구분해줬습니다.
            if let _ = dict[next] {
                dfs(next, route + " " + next, count + 1, endCount, &dict, &answer)
            } else if count == endCount - 1 {
                dfs(next, route + " " + next, count + 1, endCount, &dict, &answer)
            }
            dict[cur]![i].1 = false
        }
    }
}

func solution(_ tickets:[[String]]) -> [String] {
    var dict: Dictionary<String, [(String, Bool)]> = [:]
    var answer: [String] = []
    
    // 티켓을 딕셔너리 형태로 저장 [출발지 : [(도착지, 사용여부)]]
    for ticket in tickets {
        let start = ticket[0], next = ticket[1]
        if let _ = dict[start] {
            dict[start]!.append((next, false))
        } else {
            dict[start] = [(next, false)]
        }
    }
    
    dfs("ICN", "ICN", 1, tickets.count + 1, &dict, &answer)
    answer.sort()
    return answer[0].split(separator: " ").map { String($0) }
}
