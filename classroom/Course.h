//
//  Course.h
//  Test
//
//  Created by Kester Guischard on 4/4/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Course : NSObject{
    int CourseId;
    int User_Id;
}

@property int CourseId;
@property int User_Id;
@property (nonatomic, retain) NSDate *StartTime;
@property (nonatomic, retain) NSDate *EndTime;
@property (nonatomic, retain) NSString *CourseTitle;
@property (nonatomic, retain) NSString *CourseCode;

@end
