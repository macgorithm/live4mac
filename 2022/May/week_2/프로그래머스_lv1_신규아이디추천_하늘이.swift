//
//  main.swift
//  Lv1_신규 아이디 추천
//
//  Created by neuli on 2022/05/10.
//
//  https://programmers.co.kr/learn/courses/30/lessons/72410

import Foundation

func makeNewID(_ ID: String) -> String {
    
    // 1
    let ID = ID.lowercased()
    
    // 2
    var newID = ""
    for s in ID {
        if s.isLetter || s.isNumber || s == "-" || s == "_" || s == "." {
            newID.append(s)
        }
    }
    
    // 3
    while newID.contains("..") {
        newID = newID.replacingOccurrences(of: "..", with: ".")
    }
    
    // 4
    while newID.hasPrefix(".") { newID.removeFirst() }
    while newID.hasSuffix(".") { newID.removeLast() }
    
    // 5
    if newID == "" { newID.append("a") }
    
    // 6
    if 16 <= newID.count {
        let index = newID.index(newID.startIndex, offsetBy: 15)
        newID = String(newID[newID.startIndex..<index])
        while newID.hasSuffix(".") { newID.removeLast() }
    }
    
    // 7
    if newID.count <= 2 {
        while newID.count < 3 {
            newID += String(newID.last!)
        }
    }
    return newID
}

func solution(_ new_id:String) -> String {
    return makeNewID(new_id)
}

print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution("z-+.^."))
print(solution("=.="))
print(solution("123_.def"))
print(solution("abcdefghijklmn.p"))
