//
//  main.swift
//  Lv2_기능개발
//
//  Created by neuli on 2022/06/19.
//

import Foundation

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    
    var jobs: [Int] = progresses
    var distributeJobs: [Int] = []
    
    while !jobs.isEmpty {
        var count = 0
        for i in 0..<jobs.count where jobs[i] < 100 {
            jobs[i] += speeds[i + progresses.count - jobs.count]
        }
        for job in jobs {
            if 100 <= job {
                count += 1
                jobs.removeFirst()
            } else {
                break
            }
        }
        if count != 0 {
            distributeJobs.append(count)
        }
    }
    
    return distributeJobs
}
