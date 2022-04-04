//
//  main.swift
//  Lv3_불량 사용자
//
//  Created by 하늘이 on 2022/04/02.
//

import Foundation

// 불량아이디 패턴과 일치하는지 확인하는 함수
func isValid(_ id: String, _ pattern: String) -> Bool {
    if let _ = id.range(of: pattern, options: .regularExpression) { return true }
    return false
}

// dfs 처럼 풀었어요
func find(_ banIds: [[String]], _ banList: inout [Set<String>], _ ids: inout Set<String>, _ count: Int) {
    if count == banIds.count {
        if !banList.contains(ids) { // Set 배열을 만들어서 배열에 같은 Set이 있는지 비교
            banList.append(ids)
        }
        return
    }
    
    for id in banIds[count] {
        if !ids.contains(id) {
            ids.insert(id)
            find(banIds, &banList, &ids, count + 1)
            ids.remove(id)
        }
    }
}

func solution(_ user_id:[String], _ banned_id:[String]) -> Int {
    
    // pattern: 정규식 패턴
    // banIds: banned_id와 일치하는 패턴의 아이디들을 배열로 저장
    // banList: 정답 아이디 목록
    // ids: dfs 돌 때 필요한 Set
    var pattern: String = ""
    var banIds = Array(repeating: Array(repeating: "", count: 0), count: banned_id.count)
    var banList = Array(repeating: Set<String>(), count: 0)
    var ids: Set<String> = []
    
    for (index, banId) in banned_id.enumerated() {
        
        // 정규식 패턴
        // ex) "*rodo" -> "[a-z0-9]rodo"
        pattern = "^"
        for character in banId {
            if character == "*" {
                pattern += "[a-z0-9]"
            } else {
                pattern += String(character)
            }
        }
        pattern += "$"
        
        for id in user_id {
            if isValid(id, pattern) {
                banIds[index].append(id)
            }
        }
    }
    
    find(banIds, &banList, &ids, 0)
    
    return banList.count
}
