//
//  Note.h
//  Test
//
//  Created by Kester Guischard on 4/4/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Note : NSObject{
    int Id;
    int CourseId;
    int OwnerId;
}

@property int Id;
@property int CourseId;
@property int OwnerId;
@property (nonatomic, retain) NSDate *DateCreated;
@property (nonatomic, retain) NSString *FilePath;

@end
