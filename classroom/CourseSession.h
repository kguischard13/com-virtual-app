//
//  CourseSession.h
//  DataClass
//
//  Created by Kester Guischard on 4/11/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import "Course.h"

@interface CourseSession : Course{
    int Id;
}

@property int Id;
@property (nonatomic, retain) NSDate *MeetingDate;
@property (nonatomic, retain) NSString *ClassTopic;

@end
