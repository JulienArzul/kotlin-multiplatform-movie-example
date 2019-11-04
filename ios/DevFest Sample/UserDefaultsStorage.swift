//
//  UserDefaultsStorage.swift
//  DevFest Sample
//
//  Created by Julien Arzul on 29/10/19.
//  Copyright © 2019 Julien Arzul. All rights reserved.
//

import Foundation
import common

class UserDefaultsStorage: KeyValueStorage {
    
    let userDefaults: UserDefaults
    
    init(userDefaults: UserDefaults) {
        self.userDefaults = userDefaults
    }
    
    func storeString(key: String, value: String) {
        userDefaults.set(value, forKey: key)
    }
    
    func getString(key: String) -> String? {
        return userDefaults.string(forKey: key)
    }
}
