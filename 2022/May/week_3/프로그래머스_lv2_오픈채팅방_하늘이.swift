//
//  main.swift
//  Lv2_오픈채팅방
//
//  Created by neuli on 2022/05/14.
//

import Foundation

func solution(_ records:[String]) -> [String] {
    
    var dict: [String : String] = [:]
    var result: [String] = []
    
    for record in records {
        let record = record.split(separator: " ").map { String($0) }
        switch record[0] {
        case "Enter":
            dict[record[1], default: ""] = record[2]
        case "Change":
            dict[record[1], default: ""] = record[2]
        default:
            break
        }
    }
    
    for record in records {
        let record = record.split(separator: " ").map { String($0) }
        switch record[0] {
        case "Enter":
            if let name = dict[record[1]] {
                result.append("\(name)님이 들어왔습니다.")
            }
        case "Leave":
            if let name = dict[record[1]] {
                result.append("\(name)님이 나갔습니다.")
            }
        default:
            break
        }
    }
    
    return result
}
