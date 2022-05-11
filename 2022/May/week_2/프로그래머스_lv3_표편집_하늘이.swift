//
//  main.swift
//  Lv3_표편집
//
//  Created by neuli on 2022/05/03.
//
//  https://programmers.co.kr/learn/courses/30/lessons/81303

import Foundation

var table: [Row] = []
var deleteRow: [Int] = []
var cur: Int = 0

struct Row {
    let num: Int
    var prev: Int, next: Int
    var isTable: Bool
    init(_ num: Int, _ prev: Int, _ next: Int) {
        self.num = num
        self.prev = prev
        self.next = next
        self.isTable = true
    }
}

func command_U(_ num: Int) {
    for _ in 0..<num {
        cur = table[cur].prev
    }
}

func command_D(_ num: Int) {
    for _ in 0..<num {
        cur = table[cur].next
    }
}

func command_C() {
    let prev = table[cur].prev
    let next = table[cur].next
    if prev != -1 { table[prev].next = next }
    if next != -1 { table[next].prev = prev }
    table[cur].isTable.toggle()
    deleteRow.append(cur)
    cur = table[cur].next == -1 ? table[cur].prev : table[cur].next
}

func command_Z() {
    guard let num = deleteRow.last else { return }
    deleteRow.removeLast()
    table[num].isTable.toggle()
    let prev = table[num].prev
    let next = table[num].next
    if prev != -1 { table[prev].next = num }
    if next != -1 { table[next].prev = num }
}

func solution(_ n: Int, _ k: Int, _ cmd: [String]) -> String {
    for i in 0..<n {
        if i == n-1 { table.append(Row(i, i-1, -1)) }
        else { table.append(Row(i, i-1, i+1)) }
    }
    cur = k
    
    for command in cmd {
        switch command[command.startIndex] {
        case "U":
            let split = command.split(separator: " ")
            command_U(Int(split[1])!)
        case "D":
            let split = command.split(separator: " ")
            command_D(Int(split[1])!)
        case "C":
            command_C()
        case "Z":
            command_Z()
        default:
            break
        }
    }
    
    var result = ""
    for row in table {
        result.insert(row.isTable ? "O" : "X", at: result.endIndex)
    }
    
    return result
}
