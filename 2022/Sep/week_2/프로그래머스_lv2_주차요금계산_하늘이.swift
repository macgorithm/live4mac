//
//  main.swift
//  Lv2_주차 요금 계산
//
//  Created by neuli on 2022/09/14.
//

import Foundation

let lastOutTime = "23:59"

func solution(_ fees: [Int], _ records: [String]) -> [Int] {
    
    var cars: [String: String] = [:]    // 차 번호 : 입차시간
    var times: [String: Int] = [:]      // 차 번호 : 누적시간
    var result: [Int] = []              // 차 번호 순으로 요금 기록
    
    for record in records {
        let splitsRecord = record.components(separatedBy: " ")
        let time = splitsRecord[0]
        let carNum = splitsRecord[1]
        
        switch splitsRecord[2] {
        case "IN":
            cars[carNum] = time
        case "OUT":
            times[carNum, default: 0] += inOutTime(cars[carNum]!, time)
            cars.removeValue(forKey: carNum)    // 출차 시 입차 기록 삭제
        default: break
        }
    }
    
    // 남은 입차 기록은 23:59 출차 시간으로 누적시간 계산
    for (carNum, inTime) in cars {
        times[carNum, default: 0] += inOutTime(inTime, lastOutTime)
    }
    
    // 순서대로 차 번호
    let sortedCarNum = times.keys.sorted(by: <)
    for carNum in sortedCarNum {
        result.append(feeByInOutTime(fees, times[carNum]!))
    }
    
    return result
}

func inOutTime(_ inFee: String, _ out: String) -> Int {
    let inComponents = inFee.components(separatedBy: ":").map { Int($0)! }
    let inTime = inComponents[0] * 60 + inComponents[1]
    
    let outComponents = out.components(separatedBy: ":").map { Int($0)! }
    let outTime = outComponents[0] * 60 + outComponents[1]
    
    return outTime - inTime
}

func feeByInOutTime(_ fees: [Int], _ time: Int) -> Int {
    
    let basicTime = fees[0]
    let basicFee = fees[1]
    let unitTime = fees[2]
    let unitFee = fees[3]
    
    if time <= basicTime { return basicFee }
    
    let unitTimeFee = (time - basicTime) / unitTime * unitFee
    let restTime = (time - basicTime) % unitTime
    let restTimeFee = restTime == 0 ? 0 : unitFee
    
    return basicFee + unitTimeFee + restTimeFee
}
