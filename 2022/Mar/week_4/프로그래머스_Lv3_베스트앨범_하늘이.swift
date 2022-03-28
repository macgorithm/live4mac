//
//  main.swift
//  Lv3_베스트앨범
//
//  Created by 하늘이 on 2022/03/23.
//

import Foundation

func solution(_ genres:[String], _ plays:[Int]) -> [Int] {
    
    // <장르이름, (고유번호, 재생횟수)배열>
    var dict: Dictionary<String, [(Int, Int)]> = [:]
    var result: [Int] = []
    
    for i in 0..<genres.count {
        if let _ = dict[genres[i]] {
            dict[genres[i]]?.append((i, plays[i]))
        } else {
            dict[genres[i]] = [(i, plays[i])]
        }
    }
    
    // 장르의 전체 재생횟수가 큰 순서로 key(장르이름) 배열 생성
    let genresOrder = dict.keys.sorted(by: {
        dict[$0]!.reduce(0, { $0 + $1.1 }) > dict[$1]!.reduce(0, {$0 + $1.1})
    })
    
    // 장르마다 노래 배열을 조건에 맞춰서 정렬
    for key in dict.keys {
        dict[key]?.sort(by: { $0.1 == $1.1 ? $0.0 < $1.0 : $0.1 > $1.1 })
    }
    
    for genre in genresOrder {
        // 1개면 1번만 출력
        let count = dict[genre]!.count == 1 ? 1 : 2
        for i in 0..<count {
            if let songs = dict[genre] {
                result.append(songs[i].0)
            }
        }
    }
    
    return result
}
