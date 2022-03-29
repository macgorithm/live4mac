//
//  main.swift
//  Lv3_디스크 컨트롤러
//
//  Created by 하늘이 on 2022/03/28.
//

import Foundation

func solution(_ jobs:[[Int]]) -> Int {
    var time = 0, total = 0
    
    // 소요시간으로 정렬
    var sortedJob = jobs.sorted(by: {$0[0] == $1[0] ? $0[1] < $1[1] : $0[0] < $1[0] })
    // 요청시간으로 정렬
    sortedJob.sort(by: {$0[1] == $1[1] ? $0[0] < $1[0] : $0[1] < $1[1]})
    
    while sortedJob.count > 0 {
        for i in 0..<sortedJob.count {
            // 요청시간이 현재 시간보다 작거나 같다면
            if sortedJob[i][0] <= time {
                //현재 시간에 i번째 소요시간을 더해준다.
                time += sortedJob[i][1]
                
                total += time - sortedJob[i][0]
                sortedJob.remove(at: i)
                break
            }
            if i == sortedJob.count - 1 {
                time += 1
            }
            
        }
    }
    
    return total / jobs.count
}
