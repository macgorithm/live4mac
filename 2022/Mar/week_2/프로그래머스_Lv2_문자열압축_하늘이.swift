//
//  main.swift
//  Lv2_문자열압축
//
//  Created by 하늘이 on 2022/03/03.
//

import Foundation

func slicing(_ s: String, _ length: Int) -> [String] {
    var slicingString: [String] = []
    
    for i in stride(from: 0, to: s.count, by: length) {
        let startIndex = s.index(s.startIndex, offsetBy: i)
        var endIndex = s.index(s.startIndex, offsetBy: i)
        if s.count < i + length {
            endIndex = s.endIndex
            slicingString.append(String(s[startIndex..<endIndex]))
            break
        }
        else {
            endIndex = s.index(s.startIndex, offsetBy: i + length)
        }
        slicingString.append(String(s[startIndex..<endIndex]))
    }
    
    return slicingString
}

func compressedLength(_ s: [String]) -> Int {
    var count: Int = 0
    var startString: String = ""
    var compressedString: String = ""
    for str in s {
        if startString == str {
            count = count + 1
        }
        else {
            if startString != "" {
                compressedString.append(count == 1 ? "\(startString)" : "\(count)" + "\(startString)")
            }
            startString = str
            count = 1
        }
    }
    compressedString.append(count == 1 ? "\(startString)" : "\(count)" + "\(startString)")
    return compressedString.count
}

func solution(_ s: String) -> Int {
    var minLength: Int = s.count
    
    if minLength <= 2 {
        return minLength
    }
    
    for slice in 1...s.count/2 {
        let slicedStringArray = slicing(s, slice)
        let length = compressedLength(slicedStringArray)
        if length < minLength {
            minLength = length
        }
    }
    
    return minLength
}
