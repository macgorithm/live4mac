//
//  main.swift
//  Lv3_보석 쇼핑
//
//  Created by neuli on 2022/04/17.
//
//  https://programmers.co.kr/learn/courses/30/lessons/67258

import Foundation

func solution(_ gems:[String]) -> [Int] {
    let gemSet = Set(gems)
    var start = 0, end = 0, length = 100001, gemCount = 0
    var result: [Int] = []
    var dict: Dictionary<String, Int> = [:]
    
    for gem in gemSet {
        dict[gem] = 0
    }
    
    dict[gems[0]]! += 1
    
    // 현재 구간의 보석 종류 갯수를 세기 위한 변수
    gemCount += 1
    
    while end < gems.count {
        // 모든 종류의 보석 포함
        if gemCount == gemSet.count {
            // 보석의 종류랑 구간의 길이가 같다면 return
            if (end - start + 1) == gemSet.count {
                return [start + 1, end + 1]
            }
            // 구간의 길이가 length 보다 작다면 result 갱신
            if (end - start + 1) < length {
                length = end - start + 1
                result = [start + 1, end + 1]
            }
            // start 부분의 보석 제거
            dict[gems[start]]! -= 1
            // start 부분의 보석 제거 후 보석이 없다면 gemCount 감소
            if dict[gems[start]]! == 0 {
                gemCount -= 1
            }
            // start 와 end 가 같다면 end 증가, end 가 더 크다면 start 증가
            if start == end {
                end += 1
            } else {
                start += 1
            }
        } else { // 모든 종류의 보석을 포함하지 않을 때 end 증가
            end += 1
            if end < gems.count {
                // end 증가시키기 전 보석 갯수가 0개라면 gemCount 증가
                if dict[gems[end]]! == 0 {
                    gemCount += 1
                }
                dict[gems[end]]! += 1
            }
        }
    }
    
    return result
}
