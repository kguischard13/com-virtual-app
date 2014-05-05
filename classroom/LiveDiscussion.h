//
//  LiveDiscussion.h
//  DataClass
//
//  Created by Kester Guischard on 4/11/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import "Note.h"

@interface LiveDiscussion : Note{
    int CourseSessionId;
}

@property int CourseSessionId;
@property (nonatomic, retain) NSString *Topic;
@property(nonatomic, strong) NSMutableArray *UserList;


@end
