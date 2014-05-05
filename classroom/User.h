//
//  User.h
//  DataClass
//
//  Created by Kester Guischard on 4/11/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface User : NSObject{
    int Id;
}
@property int Id;
@property (nonatomic, retain) NSString *AccountType;
@property (nonatomic, retain) NSString *FirstName;
@property (nonatomic, retain) NSString *LastName;
@property (nonatomic, retain) NSString *PhoneNumber;
@property (nonatomic, retain) NSString *Email;
@property (nonatomic, retain) NSString *Password;



@end
