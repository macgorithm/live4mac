//
//  main.swift
//  Lv2_괄호변환
//
//  Created by neuli on 2022/07/04.
//
//  https://programmers.co.kr/learn/courses/30/lessons/60058

import Foundation

func solution(_ p: String) -> String {

    // String -> 한글자씩 배열로 변환
    let array = Array(p).map { String($0) }
    if isRight(array) { return array.joined() }
    
    return makeBalance(array).joined()
}

func makeBalance(_ arr: [String]) ->  [String] {
    // 빈 문자열이면 반환
    if arr.isEmpty { return [] }
    
    var u: [String] = []
    var v: [String] = []
    
    // 균형잡힌 문자열을 처음 발견했을 때 u 배열에 넣고,
    // 나머지는 v 배열에 넣는다.
    for i in 0..<arr.count where isBalanced(arr[0...i].map { String($0) }) {
        u = arr[0...i].map { String($0) }
        if i == (arr.count - 1) {
            v = [] // v는 빈 배열일 수도 있다.
            break
        } else {
            v = arr[(i + 1)..<arr.count].map { String($0) }
            break
        }
    }
    
    // u가 올바른 문자열이라면
    if isRight(u) {
        u += makeBalance(v) // 재귀
        return u
    } else { // u가 올바른 문자열이 아니라면
        var newArr: [String] = []
        newArr.append("(")
        newArr.append(contentsOf: makeBalance(v))
        newArr.append(")")
        newArr.append(contentsOf: reverseBracket(u))
        return newArr
    }
}

// 균형잡힌 문자열인지
func isBalanced(_ arr: [String]) -> Bool {
    var startCount = 0
    var endCount = 0
    for char in arr {
        if char == "(" {
            startCount += 1
        } else {
            endCount += 1
        }
    }
    return startCount == endCount
}

// 올바른 문자열인지
func isRight(_ arr: [String]) -> Bool {
    var stack: [String] = []
    for char in arr {
        if char == "(" {
            stack.append("(")
        } else if !stack.isEmpty {
            stack.removeLast()
        } else {
            return false
        }
    }
    if stack.isEmpty {
        return true
    } else {
        return false
    }
}

// u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집기
func reverseBracket(_ arr: [String]) -> [String] {
    var arr = arr
    arr.removeFirst()
    arr.removeLast()
    for i in 0..<arr.count {
        arr[i] = arr[i] == "(" ? ")" : "("
    }
    return arr
}
