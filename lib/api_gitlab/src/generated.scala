import Types._

import caliban.schema.Annotations._

object Types {
  case class LatestPipelineArgs(
      ref: Option[String],
      sha: Option[String],
      status: Option[PipelineStatusEnum]
  )
  case class PipelinesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int],
      ref: Option[String],
      sha: Option[String],
      status: Option[PipelineStatusEnum]
  )
  case class DiscussionsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class VersionsArgs(
      after: Option[String],
      before: Option[String],
      earlierOrEqualToId: Option[ID],
      earlierOrEqualToSha: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class DesignArgs(filename: Option[String], id: Option[ID])
  case class DesignAtVersionArgs(id: ID)
  case class DesignsArgs(
      after: Option[String],
      atVersion: Option[ID],
      before: Option[String],
      filenames: Option[List[String]],
      first: Option[Int],
      ids: Option[List[ID]],
      last: Option[Int]
  )
  case class VersionArgs(id: Option[ID], sha: Option[String])
  case class VersionsArgs(
      after: Option[String],
      before: Option[String],
      earlierOrEqualToId: Option[ID],
      earlierOrEqualToSha: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class DesignAtVersionArgs(id: ID)
  case class VersionArgs(id: ID)
  case class DesignAtVersionArgs(
      designId: Option[ID],
      filename: Option[String],
      id: Option[ID]
  )
  case class DesignsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class DesignsAtVersionArgs(
      after: Option[String],
      before: Option[String],
      filenames: Option[List[String]],
      first: Option[Int],
      ids: Option[List[ID]],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ChildrenArgs(
      after: Option[String],
      authorUsername: Option[String],
      before: Option[String],
      endDate: Option[Time],
      first: Option[Int],
      iid: Option[ID],
      iidStartsWith: Option[String],
      iids: Option[List[ID]],
      labelName: Option[List[String]],
      last: Option[Int],
      search: Option[String],
      sort: Option[EpicSort],
      startDate: Option[Time],
      state: Option[EpicState]
  )
  case class DiscussionsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class IssuesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class LabelsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ParticipantsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ReferenceArgs(full: Option[Boolean])
  case class AssigneesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class DiscussionsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class LabelsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ParticipantsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ReferenceArgs(full: Option[Boolean])
  case class BoardArgs(id: Option[ID])
  case class BoardsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      id: Option[ID],
      last: Option[Int]
  )
  case class EpicArgs(
      authorUsername: Option[String],
      endDate: Option[Time],
      iid: Option[ID],
      iidStartsWith: Option[String],
      iids: Option[List[ID]],
      labelName: Option[List[String]],
      search: Option[String],
      sort: Option[EpicSort],
      startDate: Option[Time],
      state: Option[EpicState]
  )
  case class EpicsArgs(
      after: Option[String],
      authorUsername: Option[String],
      before: Option[String],
      endDate: Option[Time],
      first: Option[Int],
      iid: Option[ID],
      iidStartsWith: Option[String],
      iids: Option[List[ID]],
      labelName: Option[List[String]],
      last: Option[Int],
      search: Option[String],
      sort: Option[EpicSort],
      startDate: Option[Time],
      state: Option[EpicState]
  )
  case class MilestonesArgs(
      after: Option[String],
      before: Option[String],
      endDate: Option[Time],
      first: Option[Int],
      last: Option[Int],
      startDate: Option[Time],
      state: Option[MilestoneStateEnum]
  )
  case class ProjectsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      includeSubgroups: Option[Boolean],
      last: Option[Int]
  )
  case class TimelogsArgs(
      after: Option[String],
      before: Option[String],
      endDate: Time,
      first: Option[Int],
      last: Option[Int],
      startDate: Time
  )
  case class AssigneesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class DiscussionsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class LabelsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ParticipantsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ReferenceArgs(full: Option[Boolean])
  case class AssigneesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class DiscussionsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class LabelsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class ParticipantsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class PipelinesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int],
      ref: Option[String],
      sha: Option[String],
      status: Option[PipelineStatusEnum]
  )
  case class ReferenceArgs(full: Option[Boolean])
  case class AddAwardEmojiArgs(input: AddAwardEmojiInput)
  case class AdminSidekiqQueuesDeleteJobsArgs(
      input: AdminSidekiqQueuesDeleteJobsInput
  )
  case class CreateDiffNoteArgs(input: CreateDiffNoteInput)
  case class CreateEpicArgs(input: CreateEpicInput)
  case class CreateImageDiffNoteArgs(input: CreateImageDiffNoteInput)
  case class CreateNoteArgs(input: CreateNoteInput)
  case class CreateSnippetArgs(input: CreateSnippetInput)
  case class DesignManagementDeleteArgs(input: DesignManagementDeleteInput)
  case class DesignManagementUploadArgs(input: DesignManagementUploadInput)
  case class DestroyNoteArgs(input: DestroyNoteInput)
  case class DestroySnippetArgs(input: DestroySnippetInput)
  case class EpicAddIssueArgs(input: EpicAddIssueInput)
  case class EpicSetSubscriptionArgs(input: EpicSetSubscriptionInput)
  case class EpicTreeReorderArgs(input: EpicTreeReorderInput)
  case class IssueSetConfidentialArgs(input: IssueSetConfidentialInput)
  case class IssueSetDueDateArgs(input: IssueSetDueDateInput)
  case class IssueSetWeightArgs(input: IssueSetWeightInput)
  case class MarkAsSpamSnippetArgs(input: MarkAsSpamSnippetInput)
  case class MergeRequestSetAssigneesArgs(input: MergeRequestSetAssigneesInput)
  case class MergeRequestSetLabelsArgs(input: MergeRequestSetLabelsInput)
  case class MergeRequestSetLockedArgs(input: MergeRequestSetLockedInput)
  case class MergeRequestSetMilestoneArgs(input: MergeRequestSetMilestoneInput)
  case class MergeRequestSetSubscriptionArgs(
      input: MergeRequestSetSubscriptionInput
  )
  case class MergeRequestSetWipArgs(input: MergeRequestSetWipInput)
  case class RemoveAwardEmojiArgs(input: RemoveAwardEmojiInput)
  case class TodoMarkDoneArgs(input: TodoMarkDoneInput)
  case class TodoRestoreArgs(input: TodoRestoreInput)
  case class TodoRestoreManyArgs(input: TodoRestoreManyInput)
  case class TodosMarkAllDoneArgs(input: TodosMarkAllDoneInput)
  case class ToggleAwardEmojiArgs(input: ToggleAwardEmojiInput)
  case class UpdateEpicArgs(input: UpdateEpicInput)
  case class UpdateImageDiffNoteArgs(input: UpdateImageDiffNoteInput)
  case class UpdateIssueArgs(input: UpdateIssueInput)
  case class UpdateNoteArgs(input: UpdateNoteInput)
  case class UpdateSnippetArgs(input: UpdateSnippetInput)
  case class ProjectsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      includeSubgroups: Option[Boolean],
      last: Option[Int]
  )
  case class BoardArgs(id: Option[ID])
  case class BoardsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      id: Option[ID],
      last: Option[Int]
  )
  case class EnvironmentsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int],
      name: Option[String],
      search: Option[String]
  )
  case class IssueArgs(
      assigneeId: Option[String],
      assigneeUsername: Option[String],
      closedAfter: Option[Time],
      closedBefore: Option[Time],
      createdAfter: Option[Time],
      createdBefore: Option[Time],
      iid: Option[ID],
      iids: Option[List[ID]],
      labelName: Option[List[Option[String]]],
      milestoneTitle: Option[List[Option[String]]],
      search: Option[String],
      sort: Option[IssueSort],
      state: Option[IssuableState],
      updatedAfter: Option[Time],
      updatedBefore: Option[Time]
  )
  case class IssuesArgs(
      after: Option[String],
      assigneeId: Option[String],
      assigneeUsername: Option[String],
      before: Option[String],
      closedAfter: Option[Time],
      closedBefore: Option[Time],
      createdAfter: Option[Time],
      createdBefore: Option[Time],
      first: Option[Int],
      iid: Option[ID],
      iids: Option[List[ID]],
      labelName: Option[List[Option[String]]],
      last: Option[Int],
      milestoneTitle: Option[List[Option[String]]],
      search: Option[String],
      sort: Option[IssueSort],
      state: Option[IssuableState],
      updatedAfter: Option[Time],
      updatedBefore: Option[Time]
  )
  case class MergeRequestArgs(iid: Option[ID], iids: Option[List[ID]])
  case class MergeRequestsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      iid: Option[ID],
      iids: Option[List[ID]],
      last: Option[Int]
  )
  case class PipelinesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int],
      ref: Option[String],
      sha: Option[String],
      status: Option[PipelineStatusEnum]
  )
  case class SentryDetailedErrorArgs(id: ID)
  case class SnippetsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      ids: Option[List[ID]],
      last: Option[Int],
      visibility: Option[VisibilityScopesEnum]
  )
  case class EchoArgs(text: String)
  case class GroupArgs(fullPath: ID)
  case class NamespaceArgs(fullPath: ID)
  case class ProjectArgs(fullPath: ID)
  case class SnippetsArgs(
      after: Option[String],
      authorId: Option[ID],
      before: Option[String],
      explore: Option[Boolean],
      first: Option[Int],
      ids: Option[List[ID]],
      last: Option[Int],
      projectId: Option[ID],
      `type`: Option[TypeEnum],
      visibility: Option[VisibilityScopesEnum]
  )
  case class TreeArgs(
      path: Option[String],
      recursive: Option[Boolean],
      ref: Option[String]
  )
  case class DetailedErrorArgs(id: ID)
  case class ErrorStackTraceArgs(id: ID)
  case class ErrorsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int],
      searchTerm: Option[String],
      sort: Option[String]
  )
  case class DiscussionsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class NotesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class BlobsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class SubmodulesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class TreesArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      last: Option[Int]
  )
  case class SnippetsArgs(
      after: Option[String],
      before: Option[String],
      first: Option[Int],
      ids: Option[List[ID]],
      last: Option[Int],
      `type`: Option[TypeEnum],
      visibility: Option[VisibilityScopesEnum]
  )
  case class TodosArgs(
      action: Option[List[TodoActionEnum]],
      after: Option[String],
      authorId: Option[List[ID]],
      before: Option[String],
      first: Option[Int],
      groupId: Option[List[ID]],
      last: Option[Int],
      projectId: Option[List[ID]],
      state: Option[List[TodoStateEnum]],
      `type`: Option[List[TodoTargetEnum]]
  )
  @GQLDescription("""Autogenerated return type of AddAwardEmoji""")
  case class AddAwardEmojiPayload(
      @GQLDescription("""The award emoji after mutation""")
      awardEmoji: Option[AwardEmoji],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  @GQLDescription(
    """Autogenerated return type of AdminSidekiqQueuesDeleteJobs"""
  )
  case class AdminSidekiqQueuesDeleteJobsPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription(
        """Information about the status of the deletion request"""
      )
      result: Option[DeleteJobsResponse]
  )
  @GQLDescription("""An emoji awarded by a user.""")
  case class AwardEmoji(
      @GQLDescription("""The emoji description""")
      description: String,
      @GQLDescription("""The emoji as an icon""")
      emoji: String,
      @GQLDescription("""The emoji name""")
      name: String,
      @GQLDescription("""The emoji in unicode""")
      unicode: String,
      @GQLDescription("""The unicode version for this emoji""")
      unicodeVersion: String,
      @GQLDescription("""The user who awarded the emoji""")
      user: User
  )
  case class Blob(
      @GQLDescription("""Flat path of the entry""")
      flatPath: String,
      @GQLDescription("""ID of the entry""")
      id: ID,
      @GQLDescription("""LFS ID of the blob""")
      lfsOid: Option[String],
      @GQLDescription("""Name of the entry""")
      name: String,
      @GQLDescription("""Path of the entry""")
      path: String,
      @GQLDescription("""Last commit sha for the entry""")
      sha: String,
      @GQLDescription("""Type of tree entry""")
      `type`: EntryType,
      @GQLDescription("""Web URL of the blob""")
      webUrl: Option[String]
  )
  @GQLDescription("""The connection type for Blob.""")
  case class BlobConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[BlobEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Blob]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class BlobEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Blob]
  )
  @GQLDescription("""Represents a project or group board""")
  case class Board(
      @GQLDescription("""ID (global ID) of the board""")
      id: ID,
      @GQLDescription("""Name of the board""")
      name: Option[String],
      @GQLDescription("""Weight of the board""")
      weight: Option[Int]
  )
  @GQLDescription("""The connection type for Board.""")
  case class BoardConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[BoardEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Board]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class BoardEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Board]
  )
  case class Commit(
      @GQLDescription("""Author of the commit""")
      author: Option[User],
      @GQLDescription("""Commit authors gravatar""")
      authorGravatar: Option[String],
      @GQLDescription("""Commit authors name""")
      authorName: Option[String],
      @GQLDescription("""Timestamp of when the commit was authored""")
      authoredDate: Option[Time],
      @GQLDescription("""Description of the commit message""")
      description: Option[String],
      @GQLDescription("""ID (global ID) of the commit""")
      id: ID,
      @GQLDescription("""Latest pipeline of the commit""")
      latestPipeline: CommitLatestPipelineArgs => Option[Pipeline],
      @GQLDescription("""Raw commit message""")
      message: Option[String],
      @GQLDescription("""Pipelines of the commit ordered latest first""")
      pipelines: CommitPipelinesArgs => Option[PipelineConnection],
      @GQLDescription("""SHA1 ID of the commit""")
      sha: String,
      @GQLDescription("""Rendered HTML of the commit signature""")
      signatureHtml: Option[String],
      @GQLDescription("""Title of the commit message""")
      title: Option[String],
      @GQLDescription("""Web URL of the commit""")
      webUrl: String
  )
  @GQLDescription("""Autogenerated return type of CreateDiffNote""")
  case class CreateDiffNotePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The note after mutation""")
      note: Option[Note]
  )
  @GQLDescription("""Autogenerated return type of CreateEpic""")
  case class CreateEpicPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The created epic""")
      epic: Option[Epic],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  @GQLDescription("""Autogenerated return type of CreateImageDiffNote""")
  case class CreateImageDiffNotePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The note after mutation""")
      note: Option[Note]
  )
  @GQLDescription("""Autogenerated return type of CreateNote""")
  case class CreateNotePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The note after mutation""")
      note: Option[Note]
  )
  @GQLDescription("""Autogenerated return type of CreateSnippet""")
  case class CreateSnippetPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The snippet after mutation""")
      snippet: Option[Snippet]
  )
  @GQLDescription(
    """The response from the AdminSidekiqQueuesDeleteJobs mutation."""
  )
  case class DeleteJobsResponse(
      @GQLDescription(
        """Whether or not the entire queue was processed in time; if not, retrying the same request is safe"""
      )
      completed: Option[Boolean],
      @GQLDescription("""The number of matching jobs deleted""")
      deletedJobs: Option[Int],
      @GQLDescription("""The queue size after processing""")
      queueSize: Option[Int]
  )
  @GQLDescription("""A single design""")
  case class Design(
      @GQLDescription("""The diff refs for this design""")
      diffRefs: DiffRefs,
      @GQLDescription("""All discussions on this noteable""")
      discussions: DesignDiscussionsArgs => DiscussionConnection,
      @GQLDescription("""How this design was changed in the current version""")
      event: DesignVersionEvent,
      @GQLDescription("""The filename of the design""")
      filename: String,
      @GQLDescription("""The full path to the design file""")
      fullPath: String,
      @GQLDescription("""The ID of this design""")
      id: ID,
      @GQLDescription("""The URL of the image""")
      image: String,
      @GQLDescription("""The issue the design belongs to""")
      issue: Issue,
      @GQLDescription("""All notes on this noteable""")
      notes: DesignNotesArgs => NoteConnection,
      @GQLDescription(
        """The total count of user-created notes for this design"""
      )
      notesCount: Int,
      @GQLDescription("""The project the design belongs to""")
      project: Project,
      @GQLDescription(
        """All versions related to this design ordered newest first"""
      )
      versions: DesignVersionsArgs => DesignVersionConnection
  )
  @GQLDescription(
    """A design pinned to a specific version. The image field reflects the design as of the associated version."""
  )
  case class DesignAtVersion(
      @GQLDescription("""The underlying design.""")
      design: Design,
      @GQLDescription("""The diff refs for this design""")
      diffRefs: DiffRefs,
      @GQLDescription("""How this design was changed in the current version""")
      event: DesignVersionEvent,
      @GQLDescription("""The filename of the design""")
      filename: String,
      @GQLDescription("""The full path to the design file""")
      fullPath: String,
      @GQLDescription("""The ID of this design""")
      id: ID,
      @GQLDescription("""The URL of the image""")
      image: String,
      @GQLDescription("""The issue the design belongs to""")
      issue: Issue,
      @GQLDescription(
        """The total count of user-created notes for this design"""
      )
      notesCount: Int,
      @GQLDescription("""The project the design belongs to""")
      project: Project,
      @GQLDescription("""The version this design-at-versions is pinned to""")
      version: DesignVersion
  )
  @GQLDescription("""The connection type for DesignAtVersion.""")
  case class DesignAtVersionConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[DesignAtVersionEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[DesignAtVersion]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class DesignAtVersionEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[DesignAtVersion]
  )
  @GQLDescription("""A collection of designs.""")
  case class DesignCollection(
      @GQLDescription("""Find a specific design""")
      design: DesignCollectionDesignArgs => Option[Design],
      @GQLDescription("""Find a design as of a version""")
      designAtVersion: DesignCollectionDesignAtVersionArgs => Option[
        DesignAtVersion
      ],
      @GQLDescription("""All designs for the design collection""")
      designs: DesignCollectionDesignsArgs => DesignConnection,
      @GQLDescription("""Issue associated with the design collection""")
      issue: Issue,
      @GQLDescription("""Project associated with the design collection""")
      project: Project,
      @GQLDescription("""A specific version""")
      version: DesignCollectionVersionArgs => Option[DesignVersion],
      @GQLDescription(
        """All versions related to all designs, ordered newest first"""
      )
      versions: DesignCollectionVersionsArgs => DesignVersionConnection
  )
  @GQLDescription("""The connection type for Design.""")
  case class DesignConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[DesignEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Design]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class DesignEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Design]
  )
  case class DesignManagement(
      @GQLDescription("""Find a design as of a version""")
      designAtVersion: DesignManagementDesignAtVersionArgs => Option[
        DesignAtVersion
      ],
      @GQLDescription("""Find a version""")
      version: DesignManagementVersionArgs => Option[DesignVersion]
  )
  @GQLDescription("""Autogenerated return type of DesignManagementDelete""")
  case class DesignManagementDeletePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The new version in which the designs are deleted""")
      version: Option[DesignVersion]
  )
  @GQLDescription("""Autogenerated return type of DesignManagementUpload""")
  case class DesignManagementUploadPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The designs that were uploaded by the mutation""")
      designs: List[Design],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription(
        """Any designs that were skipped from the upload due to there being no change to their content since their last version"""
      )
      skippedDesigns: List[Design]
  )
  @GQLDescription(
    """A specific version in which designs were added, modified or deleted"""
  )
  case class DesignVersion(
      @GQLDescription(
        """A particular design as of this version, provided it is visible at this version"""
      )
      designAtVersion: DesignVersionDesignAtVersionArgs => DesignAtVersion,
      @GQLDescription("""All designs that were changed in the version""")
      designs: DesignVersionDesignsArgs => DesignConnection,
      @GQLDescription(
        """All designs that are visible at this version, as of this version"""
      )
      designsAtVersion: DesignVersionDesignsAtVersionArgs => DesignAtVersionConnection,
      @GQLDescription("""ID of the design version""")
      id: ID,
      @GQLDescription("""SHA of the design version""")
      sha: ID
  )
  @GQLDescription("""The connection type for DesignVersion.""")
  case class DesignVersionConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[DesignVersionEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[DesignVersion]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class DesignVersionEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[DesignVersion]
  )
  @GQLDescription("""Autogenerated return type of DestroyNote""")
  case class DestroyNotePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The note after mutation""")
      note: Option[Note]
  )
  @GQLDescription("""Autogenerated return type of DestroySnippet""")
  case class DestroySnippetPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The snippet after mutation""")
      snippet: Option[Snippet]
  )
  case class DetailedStatus(
      @GQLDescription("""Path of the details for the pipeline status""")
      detailsPath: String,
      @GQLDescription("""Favicon of the pipeline status""")
      favicon: String,
      @GQLDescription("""Group of the pipeline status""")
      group: String,
      @GQLDescription(
        """Indicates if the pipeline status has further details"""
      )
      hasDetails: Boolean,
      @GQLDescription("""Icon of the pipeline status""")
      icon: String,
      @GQLDescription("""Label of the pipeline status""")
      label: String,
      @GQLDescription("""Text of the pipeline status""")
      text: String,
      @GQLDescription("""Tooltip associated with the pipeline status""")
      tooltip: String
  )
  case class DiffPosition(
      @GQLDescription(
        """Information about the branch, HEAD, and base at the time of commenting"""
      )
      diffRefs: DiffRefs,
      @GQLDescription("""Path of the file that was changed""")
      filePath: String,
      @GQLDescription("""Total height of the image""")
      height: Option[Int],
      @GQLDescription("""Line on HEAD SHA that was changed""")
      newLine: Option[Int],
      @GQLDescription("""Path of the file on the HEAD SHA""")
      newPath: Option[String],
      @GQLDescription("""Line on start SHA that was changed""")
      oldLine: Option[Int],
      @GQLDescription("""Path of the file on the start SHA""")
      oldPath: Option[String],
      @GQLDescription("""Type of file the position refers to""")
      positionType: DiffPositionType,
      @GQLDescription("""Total width of the image""")
      width: Option[Int],
      @GQLDescription("""X position of the note""")
      x: Option[Int],
      @GQLDescription("""Y position of the note""")
      y: Option[Int]
  )
  case class DiffRefs(
      @GQLDescription("""Merge base of the branch the comment was made on""")
      baseSha: Option[String],
      @GQLDescription("""SHA of the HEAD at the time the comment was made""")
      headSha: String,
      @GQLDescription("""SHA of the branch being compared against""")
      startSha: String
  )
  case class Discussion(
      @GQLDescription("""Timestamp of the discussion's creation""")
      createdAt: Time,
      @GQLDescription("""ID of this discussion""")
      id: ID,
      @GQLDescription("""All notes in the discussion""")
      notes: DiscussionNotesArgs => NoteConnection,
      @GQLDescription("""ID used to reply to this discussion""")
      replyId: ID
  )
  @GQLDescription("""The connection type for Discussion.""")
  case class DiscussionConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[DiscussionEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Discussion]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class DiscussionEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Discussion]
  )
  @GQLDescription("""Describes where code is deployed for a project""")
  case class Environment(
      @GQLDescription("""ID of the environment""")
      id: ID,
      @GQLDescription("""Human-readable name of the environment""")
      name: String
  )
  @GQLDescription("""The connection type for Environment.""")
  case class EnvironmentConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[EnvironmentEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Environment]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class EnvironmentEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Environment]
  )
  @GQLDescription("""Represents an epic.""")
  case class Epic(
      @GQLDescription("""Author of the epic""")
      author: User,
      @GQLDescription("""Children (sub-epics) of the epic""")
      children: EpicChildrenArgs => Option[EpicConnection],
      @GQLDescription("""Timestamp of the epic's closure""")
      closedAt: Option[Time],
      @GQLDescription("""Timestamp of the epic's creation""")
      createdAt: Option[Time],
      @GQLDescription(
        """Number of open and closed descendant epics and issues"""
      )
      descendantCounts: Option[EpicDescendantCount],
      @GQLDescription(
        """Total weight of open and closed issues in the epic and its descendants.
Available only when feature flag `unfiltered_epic_aggregates` is enabled."""
      )
      descendantWeightSum: Option[EpicDescendantWeights],
      @GQLDescription("""Description of the epic""")
      description: Option[String],
      @GQLDescription("""All discussions on this noteable""")
      discussions: EpicDiscussionsArgs => DiscussionConnection,
      @GQLDescription("""Number of downvotes the epic has received""")
      downvotes: Int,
      @GQLDescription("""Due date of the epic""")
      dueDate: Option[Time],
      @GQLDescription("""Fixed due date of the epic""")
      dueDateFixed: Option[Time],
      @GQLDescription("""Inherited due date of the epic from milestones""")
      dueDateFromMilestones: Option[Time],
      @GQLDescription("""Indicates if the due date has been manually set""")
      dueDateIsFixed: Option[Boolean],
      @GQLDescription("""Group to which the epic belongs""")
      group: Group,
      @GQLDescription("""Indicates if the epic has children""")
      hasChildren: Boolean,
      @GQLDescription("""Indicates if the epic has direct issues""")
      hasIssues: Boolean,
      @GQLDescription("""Current health status of the epic""")
      healthStatus: Option[EpicHealthStatus],
      @GQLDescription("""ID of the epic""")
      id: ID,
      @GQLDescription("""Internal ID of the epic""")
      iid: ID,
      @GQLDescription("""A list of issues associated with the epic""")
      issues: EpicIssuesArgs => Option[EpicIssueConnection],
      @GQLDescription("""Labels assigned to the epic""")
      labels: EpicLabelsArgs => Option[LabelConnection],
      @GQLDescription("""All notes on this noteable""")
      notes: EpicNotesArgs => NoteConnection,
      @GQLDescription("""Parent epic of the epic""")
      parent: Option[Epic],
      @GQLDescription("""List of participants for the epic""")
      participants: EpicParticipantsArgs => Option[UserConnection],
      @GQLDescription(
        """Internal reference of the epic. Returned in shortened format by default"""
      )
      reference: EpicReferenceArgs => String,
      @GQLDescription("""URI path of the epic-issue relationship""")
      relationPath: Option[String],
      @GQLDescription("""The relative position of the epic in the epic tree""")
      relativePosition: Option[Int],
      @GQLDescription("""Start date of the epic""")
      startDate: Option[Time],
      @GQLDescription("""Fixed start date of the epic""")
      startDateFixed: Option[Time],
      @GQLDescription("""Inherited start date of the epic from milestones""")
      startDateFromMilestones: Option[Time],
      @GQLDescription("""Indicates if the start date has been manually set""")
      startDateIsFixed: Option[Boolean],
      @GQLDescription("""State of the epic""")
      state: EpicState,
      @GQLDescription(
        """Indicates the currently logged in user is subscribed to the epic"""
      )
      subscribed: Boolean,
      @GQLDescription("""Title of the epic""")
      title: Option[String],
      @GQLDescription("""Timestamp of the epic's last activity""")
      updatedAt: Option[Time],
      @GQLDescription("""Number of upvotes the epic has received""")
      upvotes: Int,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: EpicPermissions,
      @GQLDescription("""Web path of the epic""")
      webPath: String,
      @GQLDescription("""Web URL of the epic""")
      webUrl: String
  )
  @GQLDescription("""Autogenerated return type of EpicAddIssue""")
  case class EpicAddIssuePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The epic after mutation""")
      epic: Option[Epic],
      @GQLDescription("""The epic-issue relation""")
      epicIssue: Option[EpicIssue],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  @GQLDescription("""The connection type for Epic.""")
  case class EpicConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[EpicEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Epic]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""Counts of descendent epics.""")
  case class EpicDescendantCount(
      @GQLDescription("""Number of closed sub-epics""")
      closedEpics: Option[Int],
      @GQLDescription("""Number of closed epic issues""")
      closedIssues: Option[Int],
      @GQLDescription("""Number of opened sub-epics""")
      openedEpics: Option[Int],
      @GQLDescription("""Number of opened epic issues""")
      openedIssues: Option[Int]
  )
  @GQLDescription("""Total weight of open and closed descendant issues""")
  case class EpicDescendantWeights(
      @GQLDescription(
        """Total weight of completed (closed) issues in this epic, including epic descendants"""
      )
      closedIssues: Option[Int],
      @GQLDescription(
        """Total weight of opened issues in this epic, including epic descendants"""
      )
      openedIssues: Option[Int]
  )
  @GQLDescription("""An edge in a connection.""")
  case class EpicEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Epic]
  )
  @GQLDescription("""Health status of child issues""")
  case class EpicHealthStatus(
      @GQLDescription("""Number of issues at risk""")
      issuesAtRisk: Option[Int],
      @GQLDescription("""Number of issues that need attention""")
      issuesNeedingAttention: Option[Int],
      @GQLDescription("""Number of issues on track""")
      issuesOnTrack: Option[Int]
  )
  @GQLDescription("""Relationship between an epic and an issue""")
  case class EpicIssue(
      @GQLDescription("""Assignees of the issue""")
      assignees: EpicIssueAssigneesArgs => Option[UserConnection],
      @GQLDescription("""User that created the issue""")
      author: User,
      @GQLDescription("""Timestamp of when the issue was closed""")
      closedAt: Option[Time],
      @GQLDescription("""Indicates the issue is confidential""")
      confidential: Boolean,
      @GQLDescription("""Timestamp of when the issue was created""")
      createdAt: Time,
      @GQLDescription("""Description of the issue""")
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription(
        """Collection of design images associated with this issue"""
      )
      designCollection: Option[DesignCollection],
      @GQLDescription("""Deprecated. Use `designCollection`""")
      designs: Option[DesignCollection],
      @GQLDescription("""Indicates discussion is locked on the issue""")
      discussionLocked: Boolean,
      @GQLDescription("""All discussions on this noteable""")
      discussions: EpicIssueDiscussionsArgs => DiscussionConnection,
      @GQLDescription("""Number of downvotes the issue has received""")
      downvotes: Int,
      @GQLDescription("""Due date of the issue""")
      dueDate: Option[Time],
      @GQLDescription("""Epic to which this issue belongs""")
      epic: Option[Epic],
      @GQLDescription("""ID of the epic-issue relation""")
      epicIssueId: ID,
      @GQLDescription(
        """Current health status. Available only when feature flag `save_issuable_health_status` is enabled."""
      )
      healthStatus: Option[HealthStatus],
      @GQLDescription("""Global ID of the epic-issue relation""")
      id: Option[ID],
      @GQLDescription("""Internal ID of the issue""")
      iid: ID,
      @GQLDescription("""Labels of the issue""")
      labels: EpicIssueLabelsArgs => Option[LabelConnection],
      @GQLDescription("""Milestone of the issue""")
      milestone: Option[Milestone],
      @GQLDescription("""All notes on this noteable""")
      notes: EpicIssueNotesArgs => NoteConnection,
      @GQLDescription("""List of participants in the issue""")
      participants: EpicIssueParticipantsArgs => Option[UserConnection],
      @GQLDescription(
        """Internal reference of the issue. Returned in shortened format by default"""
      )
      reference: EpicIssueReferenceArgs => String,
      @GQLDescription("""URI path of the epic-issue relation""")
      relationPath: Option[String],
      @GQLDescription(
        """Relative position of the issue (used for positioning in epic tree and issue boards)"""
      )
      relativePosition: Option[Int],
      @GQLDescription("""State of the issue""")
      state: IssueState,
      @GQLDescription(
        """Indicates the currently logged in user is subscribed to the issue"""
      )
      subscribed: Boolean,
      @GQLDescription("""Task completion status of the issue""")
      taskCompletionStatus: TaskCompletionStatus,
      @GQLDescription("""Time estimate of the issue""")
      timeEstimate: Int,
      @GQLDescription("""Title of the issue""")
      title: String,
      @GQLDescription("""The GitLab Flavored Markdown rendering of `title`""")
      titleHtml: Option[String],
      @GQLDescription("""Total time reported as spent on the issue""")
      totalTimeSpent: Int,
      @GQLDescription("""Timestamp of when the issue was last updated""")
      updatedAt: Time,
      @GQLDescription("""Number of upvotes the issue has received""")
      upvotes: Int,
      @GQLDescription("""Number of user notes of the issue""")
      userNotesCount: Int,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: IssuePermissions,
      @GQLDescription("""Web path of the issue""")
      webPath: String,
      @GQLDescription("""Web URL of the issue""")
      webUrl: String,
      @GQLDescription("""Weight of the issue""")
      weight: Option[Int]
  )
  @GQLDescription("""The connection type for EpicIssue.""")
  case class EpicIssueConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[EpicIssueEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[EpicIssue]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class EpicIssueEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[EpicIssue]
  )
  @GQLDescription("""Check permissions for the current user on an epic""")
  case class EpicPermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_epic` on this resource"""
      )
      adminEpic: Boolean,
      @GQLDescription(
        """Indicates the user can perform `award_emoji` on this resource"""
      )
      awardEmoji: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_epic` on this resource"""
      )
      createEpic: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_note` on this resource"""
      )
      createNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `destroy_epic` on this resource"""
      )
      destroyEpic: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_epic` on this resource"""
      )
      readEpic: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_epic_iid` on this resource"""
      )
      readEpicIid: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_epic` on this resource"""
      )
      updateEpic: Boolean
  )
  @GQLDescription("""Autogenerated return type of EpicSetSubscription""")
  case class EpicSetSubscriptionPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The epic after mutation""")
      epic: Option[Epic],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  @GQLDescription("""Autogenerated return type of EpicTreeReorder""")
  case class EpicTreeReorderPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  case class GrafanaIntegration(
      @GQLDescription("""Timestamp of the issue's creation""")
      createdAt: Time,
      @GQLDescription("""Indicates whether Grafana integration is enabled""")
      enabled: Boolean,
      @GQLDescription(
        """Url for the Grafana host for the Grafana integration"""
      )
      grafanaUrl: String,
      @GQLDescription("""Internal ID of the Grafana integration""")
      id: ID,
      @GQLDescription(
        """API token for the Grafana integration. Field is permanently masked."""
      )
      token: String,
      @GQLDescription("""Timestamp of the issue's last activity""")
      updatedAt: Time
  )
  case class Group(
      @GQLDescription(
        """Indicates whether Auto DevOps is enabled for all projects within this group"""
      )
      autoDevopsEnabled: Option[Boolean],
      @GQLDescription("""Avatar URL of the group""")
      avatarUrl: Option[String],
      @GQLDescription("""A single board of the group""")
      board: GroupBoardArgs => Option[Board],
      @GQLDescription("""Boards of the group""")
      boards: GroupBoardsArgs => Option[BoardConnection],
      @GQLDescription("""Description of the namespace""")
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription(
        """Indicates if a group has email notifications disabled"""
      )
      emailsDisabled: Option[Boolean],
      @GQLDescription("""Find a single epic""")
      epic: GroupEpicArgs => Option[Epic],
      @GQLDescription("""Find epics""")
      epics: GroupEpicsArgs => Option[EpicConnection],
      @GQLDescription("""Indicates if Epics are enabled for namespace""")
      epicsEnabled: Option[Boolean],
      @GQLDescription("""Full name of the namespace""")
      fullName: String,
      @GQLDescription("""Full path of the namespace""")
      fullPath: ID,
      @GQLDescription(
        """Indicates if Group timelogs are enabled for namespace"""
      )
      groupTimelogsEnabled: Option[Boolean],
      @GQLDescription("""ID of the namespace""")
      id: ID,
      @GQLDescription(
        """Indicates if Large File Storage (LFS) is enabled for namespace"""
      )
      lfsEnabled: Option[Boolean],
      @GQLDescription(
        """Indicates if a group is disabled from getting mentioned"""
      )
      mentionsDisabled: Option[Boolean],
      @GQLDescription("""Find milestones""")
      milestones: GroupMilestonesArgs => Option[MilestoneConnection],
      @GQLDescription("""Name of the namespace""")
      name: String,
      @GQLDescription("""Parent group""")
      parent: Option[Group],
      @GQLDescription("""Path of the namespace""")
      path: String,
      @GQLDescription(
        """The permission level required to create projects in the group"""
      )
      projectCreationLevel: Option[String],
      @GQLDescription("""Projects within this namespace""")
      projects: GroupProjectsArgs => ProjectConnection,
      @GQLDescription("""Indicates if users can request access to namespace""")
      requestAccessEnabled: Option[Boolean],
      @GQLDescription(
        """Indicates if all users in this group are required to set up two-factor authentication"""
      )
      requireTwoFactorAuthentication: Option[Boolean],
      @GQLDescription(
        """Aggregated storage statistics of the namespace. Only available for root namespaces"""
      )
      rootStorageStatistics: Option[RootStorageStatistics],
      @GQLDescription(
        """Indicates if sharing a project with another group within this group is prevented"""
      )
      shareWithGroupLock: Option[Boolean],
      @GQLDescription(
        """The permission level required to create subgroups within the group"""
      )
      subgroupCreationLevel: Option[String],
      @GQLDescription("""Time logged in issues by group members""")
      timelogs: GroupTimelogsArgs => TimelogConnection,
      @GQLDescription("""Time before two-factor authentication is enforced""")
      twoFactorGracePeriod: Option[Int],
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: GroupPermissions,
      @GQLDescription("""Visibility of the namespace""")
      visibility: Option[String],
      @GQLDescription("""Web URL of the group""")
      webUrl: String
  )
  case class GroupPermissions(
      @GQLDescription(
        """Indicates the user can perform `read_group` on this resource"""
      )
      readGroup: Boolean
  )
  case class Issue(
      @GQLDescription("""Assignees of the issue""")
      assignees: IssueAssigneesArgs => Option[UserConnection],
      @GQLDescription("""User that created the issue""")
      author: User,
      @GQLDescription("""Timestamp of when the issue was closed""")
      closedAt: Option[Time],
      @GQLDescription("""Indicates the issue is confidential""")
      confidential: Boolean,
      @GQLDescription("""Timestamp of when the issue was created""")
      createdAt: Time,
      @GQLDescription("""Description of the issue""")
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription(
        """Collection of design images associated with this issue"""
      )
      designCollection: Option[DesignCollection],
      @GQLDescription("""Deprecated. Use `designCollection`""")
      designs: Option[DesignCollection],
      @GQLDescription("""Indicates discussion is locked on the issue""")
      discussionLocked: Boolean,
      @GQLDescription("""All discussions on this noteable""")
      discussions: IssueDiscussionsArgs => DiscussionConnection,
      @GQLDescription("""Number of downvotes the issue has received""")
      downvotes: Int,
      @GQLDescription("""Due date of the issue""")
      dueDate: Option[Time],
      @GQLDescription("""Epic to which this issue belongs""")
      epic: Option[Epic],
      @GQLDescription(
        """Current health status. Available only when feature flag `save_issuable_health_status` is enabled."""
      )
      healthStatus: Option[HealthStatus],
      @GQLDescription("""Internal ID of the issue""")
      iid: ID,
      @GQLDescription("""Labels of the issue""")
      labels: IssueLabelsArgs => Option[LabelConnection],
      @GQLDescription("""Milestone of the issue""")
      milestone: Option[Milestone],
      @GQLDescription("""All notes on this noteable""")
      notes: IssueNotesArgs => NoteConnection,
      @GQLDescription("""List of participants in the issue""")
      participants: IssueParticipantsArgs => Option[UserConnection],
      @GQLDescription(
        """Internal reference of the issue. Returned in shortened format by default"""
      )
      reference: IssueReferenceArgs => String,
      @GQLDescription(
        """Relative position of the issue (used for positioning in epic tree and issue boards)"""
      )
      relativePosition: Option[Int],
      @GQLDescription("""State of the issue""")
      state: IssueState,
      @GQLDescription(
        """Indicates the currently logged in user is subscribed to the issue"""
      )
      subscribed: Boolean,
      @GQLDescription("""Task completion status of the issue""")
      taskCompletionStatus: TaskCompletionStatus,
      @GQLDescription("""Time estimate of the issue""")
      timeEstimate: Int,
      @GQLDescription("""Title of the issue""")
      title: String,
      @GQLDescription("""The GitLab Flavored Markdown rendering of `title`""")
      titleHtml: Option[String],
      @GQLDescription("""Total time reported as spent on the issue""")
      totalTimeSpent: Int,
      @GQLDescription("""Timestamp of when the issue was last updated""")
      updatedAt: Time,
      @GQLDescription("""Number of upvotes the issue has received""")
      upvotes: Int,
      @GQLDescription("""Number of user notes of the issue""")
      userNotesCount: Int,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: IssuePermissions,
      @GQLDescription("""Web path of the issue""")
      webPath: String,
      @GQLDescription("""Web URL of the issue""")
      webUrl: String,
      @GQLDescription("""Weight of the issue""")
      weight: Option[Int]
  )
  @GQLDescription("""The connection type for Issue.""")
  case class IssueConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[IssueEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Issue]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class IssueEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Issue]
  )
  @GQLDescription("""Check permissions for the current user on a issue""")
  case class IssuePermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_issue` on this resource"""
      )
      adminIssue: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_design` on this resource"""
      )
      createDesign: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_note` on this resource"""
      )
      createNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `destroy_design` on this resource"""
      )
      destroyDesign: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_design` on this resource"""
      )
      readDesign: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_issue` on this resource"""
      )
      readIssue: Boolean,
      @GQLDescription(
        """Indicates the user can perform `reopen_issue` on this resource"""
      )
      reopenIssue: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_issue` on this resource"""
      )
      updateIssue: Boolean
  )
  @GQLDescription("""Autogenerated return type of IssueSetConfidential""")
  case class IssueSetConfidentialPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The issue after mutation""")
      issue: Option[Issue]
  )
  @GQLDescription("""Autogenerated return type of IssueSetDueDate""")
  case class IssueSetDueDatePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The issue after mutation""")
      issue: Option[Issue]
  )
  @GQLDescription("""Autogenerated return type of IssueSetWeight""")
  case class IssueSetWeightPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The issue after mutation""")
      issue: Option[Issue]
  )
  case class Label(
      @GQLDescription("""Background color of the label""")
      color: String,
      @GQLDescription(
        """Description of the label (Markdown rendered as HTML for caching)"""
      )
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription("""Label ID""")
      id: ID,
      @GQLDescription("""Text color of the label""")
      textColor: String,
      @GQLDescription("""Content of the label""")
      title: String
  )
  @GQLDescription("""The connection type for Label.""")
  case class LabelConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[LabelEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Label]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class LabelEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Label]
  )
  @GQLDescription("""Autogenerated return type of MarkAsSpamSnippet""")
  case class MarkAsSpamSnippetPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The snippet after mutation""")
      snippet: Option[Snippet]
  )
  case class MergeRequest(
      @GQLDescription(
        """Indicates if members of the target project can push to the fork"""
      )
      allowCollaboration: Option[Boolean],
      @GQLDescription("""Assignees of the merge request""")
      assignees: MergeRequestAssigneesArgs => Option[UserConnection],
      @GQLDescription("""Timestamp of when the merge request was created""")
      createdAt: Time,
      @GQLDescription("""Default merge commit message of the merge request""")
      defaultMergeCommitMessage: Option[String],
      @GQLDescription(
        """Description of the merge request (Markdown rendered as HTML for caching)"""
      )
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription("""Diff head SHA of the merge request""")
      diffHeadSha: Option[String],
      @GQLDescription(
        """References of the base SHA, the head SHA, and the start SHA for this merge request"""
      )
      diffRefs: Option[DiffRefs],
      @GQLDescription(
        """Indicates if comments on the merge request are locked to members only"""
      )
      discussionLocked: Boolean,
      @GQLDescription("""All discussions on this noteable""")
      discussions: MergeRequestDiscussionsArgs => DiscussionConnection,
      @GQLDescription("""Number of downvotes for the merge request""")
      downvotes: Int,
      @GQLDescription(
        """Indicates if the project settings will lead to source branch deletion after merge"""
      )
      forceRemoveSourceBranch: Option[Boolean],
      @GQLDescription(
        """The pipeline running on the branch HEAD of the merge request"""
      )
      headPipeline: Option[Pipeline],
      @GQLDescription("""ID of the merge request""")
      id: ID,
      @GQLDescription("""Internal ID of the merge request""")
      iid: ID,
      @GQLDescription(
        """Commit SHA of the merge request if merge is in progress"""
      )
      inProgressMergeCommitSha: Option[String],
      @GQLDescription("""Labels of the merge request""")
      labels: MergeRequestLabelsArgs => Option[LabelConnection],
      @GQLDescription("""Deprecated - renamed to defaultMergeCommitMessage""")
      mergeCommitMessage: Option[String],
      @GQLDescription("""SHA of the merge request commit (set once merged)""")
      mergeCommitSha: Option[String],
      @GQLDescription("""Error message due to a merge error""")
      mergeError: Option[String],
      @GQLDescription("""Indicates if a merge is currently occurring""")
      mergeOngoing: Boolean,
      @GQLDescription("""Status of the merge request""")
      mergeStatus: Option[String],
      @GQLDescription(
        """Indicates if the merge has been set to be merged when its pipeline succeeds (MWPS)"""
      )
      mergeWhenPipelineSucceeds: Option[Boolean],
      @GQLDescription(
        """Indicates if all discussions in the merge request have been resolved, allowing the merge request to be merged"""
      )
      mergeableDiscussionsState: Option[Boolean],
      @GQLDescription("""The milestone of the merge request""")
      milestone: Option[Milestone],
      @GQLDescription("""All notes on this noteable""")
      notes: MergeRequestNotesArgs => NoteConnection,
      @GQLDescription("""Participants in the merge request""")
      participants: MergeRequestParticipantsArgs => Option[UserConnection],
      @GQLDescription("""Pipelines for the merge request""")
      pipelines: MergeRequestPipelinesArgs => PipelineConnection,
      @GQLDescription("""Alias for target_project""")
      project: Project,
      @GQLDescription("""ID of the merge request project""")
      projectId: Int,
      @GQLDescription("""Rebase commit SHA of the merge request""")
      rebaseCommitSha: Option[String],
      @GQLDescription(
        """Indicates if there is a rebase currently in progress for the merge request"""
      )
      rebaseInProgress: Boolean,
      @GQLDescription(
        """Internal reference of the merge request. Returned in shortened format by default"""
      )
      reference: MergeRequestReferenceArgs => String,
      @GQLDescription("""Indicates if the merge request will be rebased""")
      shouldBeRebased: Boolean,
      @GQLDescription(
        """Indicates if the source branch of the merge request will be deleted after merge"""
      )
      shouldRemoveSourceBranch: Option[Boolean],
      @GQLDescription("""Source branch of the merge request""")
      sourceBranch: String,
      @GQLDescription(
        """Indicates if the source branch of the merge request exists"""
      )
      sourceBranchExists: Boolean,
      @GQLDescription("""Source project of the merge request""")
      sourceProject: Option[Project],
      @GQLDescription("""ID of the merge request source project""")
      sourceProjectId: Option[Int],
      @GQLDescription("""State of the merge request""")
      state: MergeRequestState,
      @GQLDescription(
        """Indicates if the currently logged in user is subscribed to this merge request"""
      )
      subscribed: Boolean,
      @GQLDescription("""Target branch of the merge request""")
      targetBranch: String,
      @GQLDescription("""Target project of the merge request""")
      targetProject: Project,
      @GQLDescription("""ID of the merge request target project""")
      targetProjectId: Int,
      @GQLDescription("""Completion status of tasks""")
      taskCompletionStatus: TaskCompletionStatus,
      @GQLDescription("""Time estimate of the merge request""")
      timeEstimate: Int,
      @GQLDescription("""Title of the merge request""")
      title: String,
      @GQLDescription("""The GitLab Flavored Markdown rendering of `title`""")
      titleHtml: Option[String],
      @GQLDescription("""Total time reported as spent on the merge request""")
      totalTimeSpent: Int,
      @GQLDescription(
        """Timestamp of when the merge request was last updated"""
      )
      updatedAt: Time,
      @GQLDescription("""Number of upvotes for the merge request""")
      upvotes: Int,
      @GQLDescription("""User notes count of the merge request""")
      userNotesCount: Option[Int],
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: MergeRequestPermissions,
      @GQLDescription("""Web URL of the merge request""")
      webUrl: Option[String],
      @GQLDescription(
        """Indicates if the merge request is a work in progress (WIP)"""
      )
      workInProgress: Boolean
  )
  @GQLDescription("""The connection type for MergeRequest.""")
  case class MergeRequestConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[MergeRequestEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[MergeRequest]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class MergeRequestEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[MergeRequest]
  )
  @GQLDescription(
    """Check permissions for the current user on a merge request"""
  )
  case class MergeRequestPermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_merge_request` on this resource"""
      )
      adminMergeRequest: Boolean,
      @GQLDescription(
        """Indicates the user can perform `cherry_pick_on_current_merge_request` on this resource"""
      )
      cherryPickOnCurrentMergeRequest: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_note` on this resource"""
      )
      createNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `push_to_source_branch` on this resource"""
      )
      pushToSourceBranch: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_merge_request` on this resource"""
      )
      readMergeRequest: Boolean,
      @GQLDescription(
        """Indicates the user can perform `remove_source_branch` on this resource"""
      )
      removeSourceBranch: Boolean,
      @GQLDescription(
        """Indicates the user can perform `revert_on_current_merge_request` on this resource"""
      )
      revertOnCurrentMergeRequest: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_merge_request` on this resource"""
      )
      updateMergeRequest: Boolean
  )
  @GQLDescription("""Autogenerated return type of MergeRequestSetAssignees""")
  case class MergeRequestSetAssigneesPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The merge request after mutation""")
      mergeRequest: Option[MergeRequest]
  )
  @GQLDescription("""Autogenerated return type of MergeRequestSetLabels""")
  case class MergeRequestSetLabelsPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The merge request after mutation""")
      mergeRequest: Option[MergeRequest]
  )
  @GQLDescription("""Autogenerated return type of MergeRequestSetLocked""")
  case class MergeRequestSetLockedPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The merge request after mutation""")
      mergeRequest: Option[MergeRequest]
  )
  @GQLDescription("""Autogenerated return type of MergeRequestSetMilestone""")
  case class MergeRequestSetMilestonePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The merge request after mutation""")
      mergeRequest: Option[MergeRequest]
  )
  @GQLDescription(
    """Autogenerated return type of MergeRequestSetSubscription"""
  )
  case class MergeRequestSetSubscriptionPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The merge request after mutation""")
      mergeRequest: Option[MergeRequest]
  )
  @GQLDescription("""Autogenerated return type of MergeRequestSetWip""")
  case class MergeRequestSetWipPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The merge request after mutation""")
      mergeRequest: Option[MergeRequest]
  )
  case class Metadata(
      @GQLDescription("""Revision""")
      revision: String,
      @GQLDescription("""Version""")
      version: String
  )
  @GQLDescription("""Represents a milestone.""")
  case class Milestone(
      @GQLDescription("""Timestamp of milestone creation""")
      createdAt: Time,
      @GQLDescription("""Description of the milestone""")
      description: Option[String],
      @GQLDescription("""Timestamp of the milestone due date""")
      dueDate: Option[Time],
      @GQLDescription("""ID of the milestone""")
      id: ID,
      @GQLDescription("""Timestamp of the milestone start date""")
      startDate: Option[Time],
      @GQLDescription("""State of the milestone""")
      state: MilestoneStateEnum,
      @GQLDescription("""Title of the milestone""")
      title: String,
      @GQLDescription("""Timestamp of last milestone update""")
      updatedAt: Time,
      @GQLDescription("""Web path of the milestone""")
      webPath: String
  )
  @GQLDescription("""The connection type for Milestone.""")
  case class MilestoneConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[MilestoneEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Milestone]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class MilestoneEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Milestone]
  )
  case class Namespace(
      @GQLDescription("""Description of the namespace""")
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription("""Full name of the namespace""")
      fullName: String,
      @GQLDescription("""Full path of the namespace""")
      fullPath: ID,
      @GQLDescription("""ID of the namespace""")
      id: ID,
      @GQLDescription(
        """Indicates if Large File Storage (LFS) is enabled for namespace"""
      )
      lfsEnabled: Option[Boolean],
      @GQLDescription("""Name of the namespace""")
      name: String,
      @GQLDescription("""Path of the namespace""")
      path: String,
      @GQLDescription("""Projects within this namespace""")
      projects: NamespaceProjectsArgs => ProjectConnection,
      @GQLDescription("""Indicates if users can request access to namespace""")
      requestAccessEnabled: Option[Boolean],
      @GQLDescription(
        """Aggregated storage statistics of the namespace. Only available for root namespaces"""
      )
      rootStorageStatistics: Option[RootStorageStatistics],
      @GQLDescription("""Visibility of the namespace""")
      visibility: Option[String]
  )
  case class Note(
      @GQLDescription("""User who wrote this note""")
      author: User,
      @GQLDescription("""Content of the note""")
      body: String,
      @GQLDescription("""The GitLab Flavored Markdown rendering of `note`""")
      bodyHtml: Option[String],
      @GQLDescription("""Timestamp of the note creation""")
      createdAt: Time,
      @GQLDescription("""The discussion this note is a part of""")
      discussion: Option[Discussion],
      @GQLDescription("""ID of the note""")
      id: ID,
      @GQLDescription("""The position of this note on a diff""")
      position: Option[DiffPosition],
      @GQLDescription("""Project associated with the note""")
      project: Option[Project],
      @GQLDescription(
        """Indicates if this note can be resolved. That is, if it is a resolvable discussion or simply a standalone note"""
      )
      resolvable: Boolean,
      @GQLDescription("""Timestamp of the note's resolution""")
      resolvedAt: Option[Time],
      @GQLDescription("""User that resolved the discussion""")
      resolvedBy: Option[User],
      @GQLDescription(
        """Indicates whether this note was created by the system or by a user"""
      )
      system: Boolean,
      @GQLDescription("""Timestamp of the note's last activity""")
      updatedAt: Time,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: NotePermissions
  )
  @GQLDescription("""The connection type for Note.""")
  case class NoteConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[NoteEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Note]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class NoteEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Note]
  )
  case class NotePermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_note` on this resource"""
      )
      adminNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `award_emoji` on this resource"""
      )
      awardEmoji: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_note` on this resource"""
      )
      createNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_note` on this resource"""
      )
      readNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `resolve_note` on this resource"""
      )
      resolveNote: Boolean
  )
  @GQLDescription("""Information about pagination in a connection.""")
  case class PageInfo(
      @GQLDescription("""When paginating forwards, the cursor to continue.""")
      endCursor: Option[String],
      @GQLDescription("""When paginating forwards, are there more items?""")
      hasNextPage: Boolean,
      @GQLDescription("""When paginating backwards, are there more items?""")
      hasPreviousPage: Boolean,
      @GQLDescription("""When paginating backwards, the cursor to continue.""")
      startCursor: Option[String]
  )
  case class Pipeline(
      @GQLDescription("""Base SHA of the source branch""")
      beforeSha: Option[String],
      @GQLDescription("""Timestamp of the pipeline's commit""")
      committedAt: Option[Time],
      @GQLDescription("""Coverage percentage""")
      coverage: Option[Float],
      @GQLDescription("""Timestamp of the pipeline's creation""")
      createdAt: Time,
      @GQLDescription("""Detailed status of the pipeline""")
      detailedStatus: DetailedStatus,
      @GQLDescription("""Duration of the pipeline in seconds""")
      duration: Option[Int],
      @GQLDescription("""Timestamp of the pipeline's completion""")
      finishedAt: Option[Time],
      @GQLDescription("""ID of the pipeline""")
      id: ID,
      @GQLDescription("""Internal ID of the pipeline""")
      iid: ID,
      @GQLDescription("""SHA of the pipeline's commit""")
      sha: String,
      @GQLDescription("""Timestamp when the pipeline was started""")
      startedAt: Option[Time],
      @GQLDescription(
        """Status of the pipeline (CREATED, WAITING_FOR_RESOURCE, PREPARING, PENDING,
RUNNING, FAILED, SUCCESS, CANCELED, SKIPPED, MANUAL, SCHEDULED)"""
      )
      status: PipelineStatusEnum,
      @GQLDescription("""Timestamp of the pipeline's last activity""")
      updatedAt: Time,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: PipelinePermissions
  )
  @GQLDescription("""The connection type for Pipeline.""")
  case class PipelineConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[PipelineEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Pipeline]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class PipelineEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Pipeline]
  )
  case class PipelinePermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_pipeline` on this resource"""
      )
      adminPipeline: Boolean,
      @GQLDescription(
        """Indicates the user can perform `destroy_pipeline` on this resource"""
      )
      destroyPipeline: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_pipeline` on this resource"""
      )
      updatePipeline: Boolean
  )
  case class Project(
      @GQLDescription("""Indicates the archived status of the project""")
      archived: Option[Boolean],
      @GQLDescription(
        """Indicates if issues referenced by merge requests and commits within the default branch are closed automatically"""
      )
      autocloseReferencedIssues: Option[Boolean],
      @GQLDescription("""URL to avatar image file of the project""")
      avatarUrl: Option[String],
      @GQLDescription("""A single board of the project""")
      board: ProjectBoardArgs => Option[Board],
      @GQLDescription("""Boards of the project""")
      boards: ProjectBoardsArgs => Option[BoardConnection],
      @GQLDescription(
        """Indicates if the project stores Docker container images in a container registry"""
      )
      containerRegistryEnabled: Option[Boolean],
      @GQLDescription("""Timestamp of the project creation""")
      createdAt: Option[Time],
      @GQLDescription("""Short description of the project""")
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription("""Environments of the project""")
      environments: ProjectEnvironmentsArgs => Option[EnvironmentConnection],
      @GQLDescription("""Number of times the project has been forked""")
      forksCount: Int,
      @GQLDescription("""Full path of the project""")
      fullPath: ID,
      @GQLDescription("""Grafana integration details for the project""")
      grafanaIntegration: Option[GrafanaIntegration],
      @GQLDescription("""Group of the project""")
      group: Option[Group],
      @GQLDescription("""URL to connect to the project via HTTPS""")
      httpUrlToRepo: Option[String],
      @GQLDescription("""ID of the project""")
      id: ID,
      @GQLDescription(
        """Status of project import background job of the project"""
      )
      importStatus: Option[String],
      @GQLDescription("""A single issue of the project""")
      issue: ProjectIssueArgs => Option[Issue],
      @GQLDescription("""Issues of the project""")
      issues: ProjectIssuesArgs => Option[IssueConnection],
      @GQLDescription(
        """(deprecated) Does this project have issues enabled?. Use `issues_access_level` instead"""
      )
      issuesEnabled: Option[Boolean],
      @GQLDescription(
        """(deprecated) Enable jobs for this project. Use `builds_access_level` instead"""
      )
      jobsEnabled: Option[Boolean],
      @GQLDescription("""Timestamp of the project last activity""")
      lastActivityAt: Option[Time],
      @GQLDescription(
        """Indicates if the project has Large File Storage (LFS) enabled"""
      )
      lfsEnabled: Option[Boolean],
      @GQLDescription("""A single merge request of the project""")
      mergeRequest: ProjectMergeRequestArgs => Option[MergeRequest],
      @GQLDescription("""Merge requests of the project""")
      mergeRequests: ProjectMergeRequestsArgs => Option[MergeRequestConnection],
      @GQLDescription(
        """(deprecated) Does this project have merge_requests enabled?. Use `merge_requests_access_level` instead"""
      )
      mergeRequestsEnabled: Option[Boolean],
      @GQLDescription(
        """Indicates if no merge commits should be created and all merges should instead
be fast-forwarded, which means that merging is only allowed if the branch
could be fast-forwarded."""
      )
      mergeRequestsFfOnlyEnabled: Option[Boolean],
      @GQLDescription("""Name of the project (without namespace)""")
      name: String,
      @GQLDescription("""Full name of the project with its namespace""")
      nameWithNamespace: String,
      @GQLDescription("""Namespace of the project""")
      namespace: Option[Namespace],
      @GQLDescription(
        """Indicates if merge requests of the project can only be merged when all the discussions are resolved"""
      )
      onlyAllowMergeIfAllDiscussionsAreResolved: Option[Boolean],
      @GQLDescription(
        """Indicates if merge requests of the project can only be merged with successful jobs"""
      )
      onlyAllowMergeIfPipelineSucceeds: Option[Boolean],
      @GQLDescription("""Number of open issues for the project""")
      openIssuesCount: Option[Int],
      @GQLDescription("""Path of the project""")
      path: String,
      @GQLDescription("""Build pipelines of the project""")
      pipelines: ProjectPipelinesArgs => Option[PipelineConnection],
      @GQLDescription(
        """Indicates if a link to create or view a merge request should display after a
push to Git repositories of the project from the command line"""
      )
      printingMergeRequestLinkEnabled: Option[Boolean],
      @GQLDescription(
        """Indicates if there is public access to pipelines and job details of the project, including output logs and artifacts"""
      )
      publicJobs: Option[Boolean],
      @GQLDescription(
        """Indicates if `Delete source branch` option should be enabled by default for all new merge requests of the project"""
      )
      removeSourceBranchAfterMerge: Option[Boolean],
      @GQLDescription("""Git repository of the project""")
      repository: Option[Repository],
      @GQLDescription(
        """Indicates if users can request member access to the project"""
      )
      requestAccessEnabled: Option[Boolean],
      @GQLDescription("""Detailed version of a Sentry error on the project""")
      sentryDetailedError: ProjectSentryDetailedErrorArgs => Option[
        SentryDetailedError
      ],
      @GQLDescription(
        """Paginated collection of Sentry errors on the project"""
      )
      sentryErrors: Option[SentryErrorCollection],
      @GQLDescription("""E-mail address of the service desk.""")
      serviceDeskAddress: Option[String],
      @GQLDescription("""Indicates if the project has service desk enabled.""")
      serviceDeskEnabled: Option[Boolean],
      @GQLDescription(
        """Indicates if shared runners are enabled on the project"""
      )
      sharedRunnersEnabled: Option[Boolean],
      @GQLDescription("""Snippets of the project""")
      snippets: ProjectSnippetsArgs => Option[SnippetConnection],
      @GQLDescription(
        """(deprecated) Does this project have snippets enabled?. Use `snippets_access_level` instead"""
      )
      snippetsEnabled: Option[Boolean],
      @GQLDescription("""URL to connect to the project via SSH""")
      sshUrlToRepo: Option[String],
      @GQLDescription("""Number of times the project has been starred""")
      starCount: Int,
      @GQLDescription("""Statistics of the project""")
      statistics: Option[ProjectStatistics],
      @GQLDescription(
        """The commit message used to apply merge request suggestions"""
      )
      suggestionCommitMessage: Option[String],
      @GQLDescription("""List of project tags""")
      tagList: Option[String],
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: ProjectPermissions,
      @GQLDescription("""Visibility of the project""")
      visibility: Option[String],
      @GQLDescription("""Web URL of the project""")
      webUrl: Option[String],
      @GQLDescription(
        """(deprecated) Does this project have wiki enabled?. Use `wiki_access_level` instead"""
      )
      wikiEnabled: Option[Boolean]
  )
  @GQLDescription("""The connection type for Project.""")
  case class ProjectConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[ProjectEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Project]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class ProjectEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Project]
  )
  case class ProjectPermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_operations` on this resource"""
      )
      adminOperations: Boolean,
      @GQLDescription(
        """Indicates the user can perform `admin_project` on this resource"""
      )
      adminProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `admin_remote_mirror` on this resource"""
      )
      adminRemoteMirror: Boolean,
      @GQLDescription(
        """Indicates the user can perform `admin_wiki` on this resource"""
      )
      adminWiki: Boolean,
      @GQLDescription(
        """Indicates the user can perform `archive_project` on this resource"""
      )
      archiveProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `change_namespace` on this resource"""
      )
      changeNamespace: Boolean,
      @GQLDescription(
        """Indicates the user can perform `change_visibility_level` on this resource"""
      )
      changeVisibilityLevel: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_deployment` on this resource"""
      )
      createDeployment: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_design` on this resource"""
      )
      createDesign: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_issue` on this resource"""
      )
      createIssue: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_label` on this resource"""
      )
      createLabel: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_merge_request_from` on this resource"""
      )
      createMergeRequestFrom: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_merge_request_in` on this resource"""
      )
      createMergeRequestIn: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_pages` on this resource"""
      )
      createPages: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_pipeline` on this resource"""
      )
      createPipeline: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_pipeline_schedule` on this resource"""
      )
      createPipelineSchedule: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_snippet` on this resource"""
      )
      createSnippet: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_wiki` on this resource"""
      )
      createWiki: Boolean,
      @GQLDescription(
        """Indicates the user can perform `destroy_design` on this resource"""
      )
      destroyDesign: Boolean,
      @GQLDescription(
        """Indicates the user can perform `destroy_pages` on this resource"""
      )
      destroyPages: Boolean,
      @GQLDescription(
        """Indicates the user can perform `destroy_wiki` on this resource"""
      )
      destroyWiki: Boolean,
      @GQLDescription(
        """Indicates the user can perform `download_code` on this resource"""
      )
      downloadCode: Boolean,
      @GQLDescription(
        """Indicates the user can perform `download_wiki_code` on this resource"""
      )
      downloadWikiCode: Boolean,
      @GQLDescription(
        """Indicates the user can perform `fork_project` on this resource"""
      )
      forkProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `push_code` on this resource"""
      )
      pushCode: Boolean,
      @GQLDescription(
        """Indicates the user can perform `push_to_delete_protected_branch` on this resource"""
      )
      pushToDeleteProtectedBranch: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_commit_status` on this resource"""
      )
      readCommitStatus: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_cycle_analytics` on this resource"""
      )
      readCycleAnalytics: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_design` on this resource"""
      )
      readDesign: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_merge_request` on this resource"""
      )
      readMergeRequest: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_pages_content` on this resource"""
      )
      readPagesContent: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_project` on this resource"""
      )
      readProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_project_member` on this resource"""
      )
      readProjectMember: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_wiki` on this resource"""
      )
      readWiki: Boolean,
      @GQLDescription(
        """Indicates the user can perform `remove_fork_project` on this resource"""
      )
      removeForkProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `remove_pages` on this resource"""
      )
      removePages: Boolean,
      @GQLDescription(
        """Indicates the user can perform `remove_project` on this resource"""
      )
      removeProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `rename_project` on this resource"""
      )
      renameProject: Boolean,
      @GQLDescription(
        """Indicates the user can perform `request_access` on this resource"""
      )
      requestAccess: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_pages` on this resource"""
      )
      updatePages: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_wiki` on this resource"""
      )
      updateWiki: Boolean,
      @GQLDescription(
        """Indicates the user can perform `upload_file` on this resource"""
      )
      uploadFile: Boolean
  )
  case class ProjectStatistics(
      @GQLDescription("""Build artifacts size of the project""")
      buildArtifactsSize: Int,
      @GQLDescription("""Commit count of the project""")
      commitCount: Int,
      @GQLDescription("""Large File Storage (LFS) object size of the project""")
      lfsObjectsSize: Int,
      @GQLDescription("""Packages size of the project""")
      packagesSize: Int,
      @GQLDescription("""Repository size of the project""")
      repositorySize: Int,
      @GQLDescription("""Storage size of the project""")
      storageSize: Int,
      @GQLDescription("""Wiki size of the project""")
      wikiSize: Option[Int]
  )
  @GQLDescription("""Autogenerated return type of RemoveAwardEmoji""")
  case class RemoveAwardEmojiPayload(
      @GQLDescription("""The award emoji after mutation""")
      awardEmoji: Option[AwardEmoji],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  case class Repository(
      @GQLDescription("""Indicates repository has no visible content""")
      empty: Boolean,
      @GQLDescription(
        """Indicates a corresponding Git repository exists on disk"""
      )
      exists: Boolean,
      @GQLDescription("""Default branch of the repository""")
      rootRef: Option[String],
      @GQLDescription("""Tree of the repository""")
      tree: RepositoryTreeArgs => Option[Tree]
  )
  case class RootStorageStatistics(
      @GQLDescription("""The CI artifacts size in bytes""")
      buildArtifactsSize: Int,
      @GQLDescription("""The LFS objects size in bytes""")
      lfsObjectsSize: Int,
      @GQLDescription("""The packages size in bytes""")
      packagesSize: Int,
      @GQLDescription("""The Git repository size in bytes""")
      repositorySize: Int,
      @GQLDescription("""The total storage in bytes""")
      storageSize: Int,
      @GQLDescription("""The wiki size in bytes""")
      wikiSize: Int
  )
  @GQLDescription("""A Sentry error.""")
  case class SentryDetailedError(
      @GQLDescription("""Count of occurrences""")
      count: Int,
      @GQLDescription("""Culprit of the error""")
      culprit: String,
      @GQLDescription("""External Base URL of the Sentry Instance""")
      externalBaseUrl: String,
      @GQLDescription("""External URL of the error""")
      externalUrl: String,
      @GQLDescription("""Commit the error was first seen""")
      firstReleaseLastCommit: Option[String],
      @GQLDescription("""Release version the error was first seen""")
      firstReleaseShortVersion: Option[String],
      @GQLDescription("""Timestamp when the error was first seen""")
      firstSeen: Time,
      @GQLDescription("""Last 24hr stats of the error""")
      frequency: List[SentryErrorFrequency],
      @GQLDescription(
        """GitLab commit SHA attributed to the Error based on the release version"""
      )
      gitlabCommit: Option[String],
      @GQLDescription(
        """Path to the GitLab page for the GitLab commit attributed to the error"""
      )
      gitlabCommitPath: Option[String],
      @GQLDescription("""URL of GitLab Issue""")
      gitlabIssuePath: Option[String],
      @GQLDescription("""ID (global ID) of the error""")
      id: ID,
      @GQLDescription("""Commit the error was last seen""")
      lastReleaseLastCommit: Option[String],
      @GQLDescription("""Release version the error was last seen""")
      lastReleaseShortVersion: Option[String],
      @GQLDescription("""Timestamp when the error was last seen""")
      lastSeen: Time,
      @GQLDescription("""Sentry metadata message of the error""")
      message: Option[String],
      @GQLDescription("""ID (Sentry ID) of the error""")
      sentryId: String,
      @GQLDescription("""ID of the project (Sentry project)""")
      sentryProjectId: ID,
      @GQLDescription("""Name of the project affected by the error""")
      sentryProjectName: String,
      @GQLDescription("""Slug of the project affected by the error""")
      sentryProjectSlug: String,
      @GQLDescription("""Short ID (Sentry ID) of the error""")
      shortId: String,
      @GQLDescription("""Status of the error""")
      status: SentryErrorStatus,
      @GQLDescription("""Tags associated with the Sentry Error""")
      tags: SentryErrorTags,
      @GQLDescription("""Title of the error""")
      title: String,
      @GQLDescription("""Type of the error""")
      `type`: String,
      @GQLDescription("""Count of users affected by the error""")
      userCount: Int
  )
  @GQLDescription(
    """A Sentry error. A simplified version of SentryDetailedError."""
  )
  case class SentryError(
      @GQLDescription("""Count of occurrences""")
      count: Int,
      @GQLDescription("""Culprit of the error""")
      culprit: String,
      @GQLDescription("""External URL of the error""")
      externalUrl: String,
      @GQLDescription("""Timestamp when the error was first seen""")
      firstSeen: Time,
      @GQLDescription("""Last 24hr stats of the error""")
      frequency: List[SentryErrorFrequency],
      @GQLDescription("""ID (global ID) of the error""")
      id: ID,
      @GQLDescription("""Timestamp when the error was last seen""")
      lastSeen: Time,
      @GQLDescription("""Sentry metadata message of the error""")
      message: Option[String],
      @GQLDescription("""ID (Sentry ID) of the error""")
      sentryId: String,
      @GQLDescription("""ID of the project (Sentry project)""")
      sentryProjectId: ID,
      @GQLDescription("""Name of the project affected by the error""")
      sentryProjectName: String,
      @GQLDescription("""Slug of the project affected by the error""")
      sentryProjectSlug: String,
      @GQLDescription("""Short ID (Sentry ID) of the error""")
      shortId: String,
      @GQLDescription("""Status of the error""")
      status: SentryErrorStatus,
      @GQLDescription("""Title of the error""")
      title: String,
      @GQLDescription("""Type of the error""")
      `type`: String,
      @GQLDescription("""Count of users affected by the error""")
      userCount: Int
  )
  @GQLDescription(
    """An object containing a collection of Sentry errors, and a detailed error."""
  )
  case class SentryErrorCollection(
      @GQLDescription("""Detailed version of a Sentry error on the project""")
      detailedError: SentryErrorCollectionDetailedErrorArgs => Option[
        SentryDetailedError
      ],
      @GQLDescription("""Stack Trace of Sentry Error""")
      errorStackTrace: SentryErrorCollectionErrorStackTraceArgs => Option[
        SentryErrorStackTrace
      ],
      @GQLDescription("""Collection of Sentry Errors""")
      errors: SentryErrorCollectionErrorsArgs => Option[SentryErrorConnection],
      @GQLDescription("""External URL for Sentry""")
      externalUrl: Option[String]
  )
  @GQLDescription("""The connection type for SentryError.""")
  case class SentryErrorConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[SentryErrorEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[SentryError]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class SentryErrorEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[SentryError]
  )
  case class SentryErrorFrequency(
      @GQLDescription(
        """Count of errors received since the previously recorded time"""
      )
      count: Int,
      @GQLDescription("""Time the error frequency stats were recorded""")
      time: Time
  )
  @GQLDescription(
    """An object containing a stack trace entry for a Sentry error."""
  )
  case class SentryErrorStackTrace(
      @GQLDescription("""Time the stack trace was received by Sentry""")
      dateReceived: String,
      @GQLDescription("""ID of the Sentry error""")
      issueId: String,
      @GQLDescription("""Stack trace entries for the Sentry error""")
      stackTraceEntries: List[SentryErrorStackTraceEntry]
  )
  @GQLDescription("""An object context for a Sentry error stack trace""")
  case class SentryErrorStackTraceContext(
      @GQLDescription("""Code number of the context""")
      code: String,
      @GQLDescription("""Line number of the context""")
      line: Int
  )
  @GQLDescription(
    """An object containing a stack trace entry for a Sentry error."""
  )
  case class SentryErrorStackTraceEntry(
      @GQLDescription("""Function in which the Sentry error occurred""")
      col: Option[String],
      @GQLDescription("""File in which the Sentry error occurred""")
      fileName: Option[String],
      @GQLDescription("""Function in which the Sentry error occurred""")
      function: Option[String],
      @GQLDescription("""Function in which the Sentry error occurred""")
      line: Option[String],
      @GQLDescription("""Context of the Sentry error""")
      traceContext: Option[List[SentryErrorStackTraceContext]]
  )
  @GQLDescription("""State of a Sentry error""")
  case class SentryErrorTags(
      @GQLDescription("""Severity level of the Sentry Error""")
      level: Option[String],
      @GQLDescription("""Logger of the Sentry Error""")
      logger: Option[String]
  )
  @GQLDescription("""Represents a snippet entry""")
  case class Snippet(
      @GQLDescription("""The owner of the snippet""")
      author: User,
      @GQLDescription("""Snippet blob""")
      blob: SnippetBlob,
      @GQLDescription("""Timestamp this snippet was created""")
      createdAt: Time,
      @GQLDescription("""Description of the snippet""")
      description: Option[String],
      @GQLDescription(
        """The GitLab Flavored Markdown rendering of `description`"""
      )
      descriptionHtml: Option[String],
      @GQLDescription("""All discussions on this noteable""")
      discussions: SnippetDiscussionsArgs => DiscussionConnection,
      @GQLDescription("""File Name of the snippet""")
      fileName: Option[String],
      @GQLDescription("""Id of the snippet""")
      id: ID,
      @GQLDescription("""All notes on this noteable""")
      notes: SnippetNotesArgs => NoteConnection,
      @GQLDescription("""The project the snippet is associated with""")
      project: Option[Project],
      @GQLDescription("""Raw URL of the snippet""")
      rawUrl: String,
      @GQLDescription("""Title of the snippet""")
      title: String,
      @GQLDescription("""Timestamp this snippet was updated""")
      updatedAt: Time,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: SnippetPermissions,
      @GQLDescription("""Visibility Level of the snippet""")
      visibilityLevel: VisibilityLevelsEnum,
      @GQLDescription("""Web URL of the snippet""")
      webUrl: String
  )
  @GQLDescription("""Represents the snippet blob""")
  case class SnippetBlob(
      @GQLDescription("""Shows whether the blob is binary""")
      binary: Boolean,
      @GQLDescription("""Blob mode""")
      mode: Option[String],
      @GQLDescription("""Blob name""")
      name: Option[String],
      @GQLDescription("""Blob path""")
      path: Option[String],
      @GQLDescription("""Blob plain highlighted data""")
      plainData: Option[String],
      @GQLDescription("""Blob raw content endpoint path""")
      rawPath: String,
      @GQLDescription("""Blob highlighted data""")
      richData: Option[String],
      @GQLDescription("""Blob content rich viewer""")
      richViewer: Option[SnippetBlobViewer],
      @GQLDescription("""Blob content simple viewer""")
      simpleViewer: SnippetBlobViewer,
      @GQLDescription("""Blob size""")
      size: Int
  )
  @GQLDescription("""Represents how the blob content should be displayed""")
  case class SnippetBlobViewer(
      @GQLDescription(
        """Shows whether the blob should be displayed collapsed"""
      )
      collapsed: Boolean,
      @GQLDescription("""Content file type""")
      fileType: String,
      @GQLDescription("""Shows whether the blob content is loaded async""")
      loadAsync: Boolean,
      @GQLDescription("""Loading partial name""")
      loadingPartialName: String,
      @GQLDescription("""Error rendering the blob content""")
      renderError: Option[String],
      @GQLDescription("""Shows whether the blob too large to be displayed""")
      tooLarge: Boolean,
      @GQLDescription("""Type of blob viewer""")
      `type`: BlobViewersType
  )
  @GQLDescription("""The connection type for Snippet.""")
  case class SnippetConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[SnippetEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Snippet]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class SnippetEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Snippet]
  )
  case class SnippetPermissions(
      @GQLDescription(
        """Indicates the user can perform `admin_snippet` on this resource"""
      )
      adminSnippet: Boolean,
      @GQLDescription(
        """Indicates the user can perform `award_emoji` on this resource"""
      )
      awardEmoji: Boolean,
      @GQLDescription(
        """Indicates the user can perform `create_note` on this resource"""
      )
      createNote: Boolean,
      @GQLDescription(
        """Indicates the user can perform `read_snippet` on this resource"""
      )
      readSnippet: Boolean,
      @GQLDescription(
        """Indicates the user can perform `report_snippet` on this resource"""
      )
      reportSnippet: Boolean,
      @GQLDescription(
        """Indicates the user can perform `update_snippet` on this resource"""
      )
      updateSnippet: Boolean
  )
  case class Submodule(
      @GQLDescription("""Flat path of the entry""")
      flatPath: String,
      @GQLDescription("""ID of the entry""")
      id: ID,
      @GQLDescription("""Name of the entry""")
      name: String,
      @GQLDescription("""Path of the entry""")
      path: String,
      @GQLDescription("""Last commit sha for the entry""")
      sha: String,
      @GQLDescription("""Tree URL for the sub-module""")
      treeUrl: Option[String],
      @GQLDescription("""Type of tree entry""")
      `type`: EntryType,
      @GQLDescription("""Web URL for the sub-module""")
      webUrl: Option[String]
  )
  @GQLDescription("""The connection type for Submodule.""")
  case class SubmoduleConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[SubmoduleEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Submodule]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class SubmoduleEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Submodule]
  )
  @GQLDescription("""Completion status of tasks""")
  case class TaskCompletionStatus(
      @GQLDescription("""Number of completed tasks""")
      completedCount: Int,
      @GQLDescription("""Number of total tasks""")
      count: Int
  )
  case class Timelog(
      @GQLDescription("""The date when the time tracked was spent at""")
      date: Time,
      @GQLDescription("""The issue that logged time was added to""")
      issue: Option[Issue],
      @GQLDescription("""The time spent displayed in seconds""")
      timeSpent: Int,
      @GQLDescription("""The user that logged the time""")
      user: User
  )
  @GQLDescription("""The connection type for Timelog.""")
  case class TimelogConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[TimelogEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Timelog]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class TimelogEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Timelog]
  )
  @GQLDescription("""Representing a todo entry""")
  case class Todo(
      @GQLDescription("""Action of the todo""")
      action: TodoActionEnum,
      @GQLDescription("""The owner of this todo""")
      author: User,
      @GQLDescription("""Body of the todo""")
      body: String,
      @GQLDescription("""Timestamp this todo was created""")
      createdAt: Time,
      @GQLDescription("""Group this todo is associated with""")
      group: Option[Group],
      @GQLDescription("""Id of the todo""")
      id: ID,
      @GQLDescription("""The project this todo is associated with""")
      project: Option[Project],
      @GQLDescription("""State of the todo""")
      state: TodoStateEnum,
      @GQLDescription("""Target type of the todo""")
      targetType: TodoTargetEnum
  )
  @GQLDescription("""The connection type for Todo.""")
  case class TodoConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[TodoEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[Todo]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class TodoEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[Todo]
  )
  @GQLDescription("""Autogenerated return type of TodoMarkDone""")
  case class TodoMarkDonePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The requested todo""")
      todo: Todo
  )
  @GQLDescription("""Autogenerated return type of TodoRestoreMany""")
  case class TodoRestoreManyPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The ids of the updated todo items""")
      updatedIds: List[ID]
  )
  @GQLDescription("""Autogenerated return type of TodoRestore""")
  case class TodoRestorePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The requested todo""")
      todo: Todo
  )
  @GQLDescription("""Autogenerated return type of TodosMarkAllDone""")
  case class TodosMarkAllDonePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""Ids of the updated todos""")
      updatedIds: List[ID]
  )
  @GQLDescription("""Autogenerated return type of ToggleAwardEmoji""")
  case class ToggleAwardEmojiPayload(
      @GQLDescription("""The award emoji after mutation""")
      awardEmoji: Option[AwardEmoji],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription(
        """Indicates the status of the emoji. True if the toggle awarded the emoji, and false if the toggle removed the emoji."""
      )
      toggledOn: Boolean
  )
  case class Tree(
      @GQLDescription("""Blobs of the tree""")
      blobs: TreeBlobsArgs => BlobConnection,
      @GQLDescription("""Last commit for the tree""")
      lastCommit: Option[Commit],
      @GQLDescription("""Sub-modules of the tree""")
      submodules: TreeSubmodulesArgs => SubmoduleConnection,
      @GQLDescription("""Trees of the tree""")
      trees: TreeTreesArgs => TreeEntryConnection
  )
  @GQLDescription("""Represents a directory""")
  case class TreeEntry(
      @GQLDescription("""Flat path of the entry""")
      flatPath: String,
      @GQLDescription("""ID of the entry""")
      id: ID,
      @GQLDescription("""Name of the entry""")
      name: String,
      @GQLDescription("""Path of the entry""")
      path: String,
      @GQLDescription("""Last commit sha for the entry""")
      sha: String,
      @GQLDescription("""Type of tree entry""")
      `type`: EntryType,
      @GQLDescription("""Web URL for the tree entry (directory)""")
      webUrl: Option[String]
  )
  @GQLDescription("""The connection type for TreeEntry.""")
  case class TreeEntryConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[TreeEntryEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[TreeEntry]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class TreeEntryEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[TreeEntry]
  )
  @GQLDescription("""Autogenerated return type of UpdateEpic""")
  case class UpdateEpicPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The epic after mutation""")
      epic: Option[Epic],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String]
  )
  @GQLDescription("""Autogenerated return type of UpdateImageDiffNote""")
  case class UpdateImageDiffNotePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The note after mutation""")
      note: Option[Note]
  )
  @GQLDescription("""Autogenerated return type of UpdateIssue""")
  case class UpdateIssuePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The issue after mutation""")
      issue: Option[Issue]
  )
  @GQLDescription("""Autogenerated return type of UpdateNote""")
  case class UpdateNotePayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The note after mutation""")
      note: Option[Note]
  )
  @GQLDescription("""Autogenerated return type of UpdateSnippet""")
  case class UpdateSnippetPayload(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Reasons why the mutation failed.""")
      errors: List[String],
      @GQLDescription("""The snippet after mutation""")
      snippet: Option[Snippet]
  )
  case class User(
      @GQLDescription("""URL of the user's avatar""")
      avatarUrl: Option[String],
      @GQLDescription("""Human-readable name of the user""")
      name: String,
      @GQLDescription("""Snippets authored by the user""")
      snippets: UserSnippetsArgs => Option[SnippetConnection],
      @GQLDescription("""Todos of the user""")
      todos: UserTodosArgs => TodoConnection,
      @GQLDescription("""Permissions for the current user on the resource""")
      userPermissions: UserPermissions,
      @GQLDescription(
        """Username of the user. Unique within this instance of GitLab"""
      )
      username: String,
      @GQLDescription("""Web URL of the user""")
      webUrl: String
  )
  @GQLDescription("""The connection type for User.""")
  case class UserConnection(
      @GQLDescription("""A list of edges.""")
      edges: Option[List[Option[UserEdge]]],
      @GQLDescription("""A list of nodes.""")
      nodes: Option[List[Option[User]]],
      @GQLDescription("""Information to aid in pagination.""")
      pageInfo: PageInfo
  )
  @GQLDescription("""An edge in a connection.""")
  case class UserEdge(
      @GQLDescription("""A cursor for use in pagination.""")
      cursor: String,
      @GQLDescription("""The item at the end of the edge.""")
      node: Option[User]
  )
  case class UserPermissions(
      @GQLDescription(
        """Indicates the user can perform `create_snippet` on this resource"""
      )
      createSnippet: Boolean
  )
  @GQLDescription("""Autogenerated input type of AddAwardEmoji""")
  case class AddAwardEmojiInput(
      @GQLDescription("""The global id of the awardable resource""")
      awardableId: ID,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The emoji name""")
      name: String
  )
  @GQLDescription(
    """Autogenerated input type of AdminSidekiqQueuesDeleteJobs"""
  )
  case class AdminSidekiqQueuesDeleteJobsInput(
      @GQLDescription(
        """Delete jobs matching caller_id in the context metadata"""
      )
      callerId: Option[String],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription(
        """Delete jobs matching project in the context metadata"""
      )
      project: Option[String],
      @GQLDescription("""The name of the queue to delete jobs from""")
      queueName: String,
      @GQLDescription(
        """Delete jobs matching root_namespace in the context metadata"""
      )
      rootNamespace: Option[String],
      @GQLDescription(
        """Delete jobs matching subscription_plan in the context metadata"""
      )
      subscriptionPlan: Option[String],
      @GQLDescription("""Delete jobs matching user in the context metadata""")
      user: Option[String]
  )
  @GQLDescription("""Autogenerated input type of CreateDiffNote""")
  case class CreateDiffNoteInput(
      @GQLDescription("""Content of the note""")
      body: String,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the resource to add a note to""")
      noteableId: ID,
      @GQLDescription("""The position of this note on a diff""")
      position: DiffPositionInput
  )
  @GQLDescription("""Autogenerated input type of CreateEpic""")
  case class CreateEpicInput(
      @GQLDescription("""The IDs of labels to be added to the epic.""")
      addLabelIds: Option[List[ID]],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The description of the epic""")
      description: Option[String],
      @GQLDescription("""The end date of the epic""")
      dueDateFixed: Option[String],
      @GQLDescription(
        """Indicates end date should be sourced from due_date_fixed field not the issue milestones"""
      )
      dueDateIsFixed: Option[Boolean],
      @GQLDescription("""The group the epic to mutate is in""")
      groupPath: ID,
      @GQLDescription("""The IDs of labels to be removed from the epic.""")
      removeLabelIds: Option[List[ID]],
      @GQLDescription("""The start date of the epic""")
      startDateFixed: Option[String],
      @GQLDescription(
        """Indicates start date should be sourced from start_date_fixed field not the issue milestones"""
      )
      startDateIsFixed: Option[Boolean],
      @GQLDescription("""The title of the epic""")
      title: Option[String]
  )
  @GQLDescription("""Autogenerated input type of CreateImageDiffNote""")
  case class CreateImageDiffNoteInput(
      @GQLDescription("""Content of the note""")
      body: String,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the resource to add a note to""")
      noteableId: ID,
      @GQLDescription("""The position of this note on a diff""")
      position: DiffImagePositionInput
  )
  @GQLDescription("""Autogenerated input type of CreateNote""")
  case class CreateNoteInput(
      @GQLDescription("""Content of the note""")
      body: String,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription(
        """The global id of the discussion this note is in reply to"""
      )
      discussionId: Option[ID],
      @GQLDescription("""The global id of the resource to add a note to""")
      noteableId: ID
  )
  @GQLDescription("""Autogenerated input type of CreateSnippet""")
  case class CreateSnippetInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Content of the snippet""")
      content: String,
      @GQLDescription("""Description of the snippet""")
      description: Option[String],
      @GQLDescription("""File name of the snippet""")
      fileName: Option[String],
      @GQLDescription(
        """The project full path the snippet is associated with"""
      )
      projectPath: Option[ID],
      @GQLDescription("""Title of the snippet""")
      title: String,
      @GQLDescription("""The visibility level of the snippet""")
      visibilityLevel: VisibilityLevelsEnum
  )
  @GQLDescription("""Autogenerated input type of DesignManagementDelete""")
  case class DesignManagementDeleteInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The filenames of the designs to delete""")
      filenames: List[String],
      @GQLDescription("""The iid of the issue to modify designs for""")
      iid: ID,
      @GQLDescription(
        """The project where the issue is to upload designs for"""
      )
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of DesignManagementUpload""")
  case class DesignManagementUploadInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The files to upload""")
      files: List[Upload],
      @GQLDescription("""The iid of the issue to modify designs for""")
      iid: ID,
      @GQLDescription(
        """The project where the issue is to upload designs for"""
      )
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of DestroyNote""")
  case class DestroyNoteInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the note to destroy""")
      id: ID
  )
  @GQLDescription("""Autogenerated input type of DestroySnippet""")
  case class DestroySnippetInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the snippet to destroy""")
      id: ID
  )
  case class DiffImagePositionInput(
      @GQLDescription("""Merge base of the branch the comment was made on""")
      baseSha: Option[String],
      @GQLDescription("""SHA of the HEAD at the time the comment was made""")
      headSha: String,
      @GQLDescription("""Total height of the image""")
      height: Int,
      @GQLDescription(
        """The paths of the file that was changed. Both of the properties of this input
are optional, but at least one of them is required"""
      )
      paths: DiffPathsInput,
      @GQLDescription("""SHA of the branch being compared against""")
      startSha: String,
      @GQLDescription("""Total width of the image""")
      width: Int,
      @GQLDescription("""X position of the note""")
      x: Int,
      @GQLDescription("""Y position of the note""")
      y: Int
  )
  case class DiffPathsInput(
      @GQLDescription("""The path of the file on the head sha""")
      newPath: Option[String],
      @GQLDescription("""The path of the file on the start sha""")
      oldPath: Option[String]
  )
  case class DiffPositionInput(
      @GQLDescription("""Merge base of the branch the comment was made on""")
      baseSha: Option[String],
      @GQLDescription("""SHA of the HEAD at the time the comment was made""")
      headSha: String,
      @GQLDescription("""Line on HEAD SHA that was changed""")
      newLine: Int,
      @GQLDescription("""Line on start SHA that was changed""")
      oldLine: Option[Int],
      @GQLDescription(
        """The paths of the file that was changed. Both of the properties of this input
are optional, but at least one of them is required"""
      )
      paths: DiffPathsInput,
      @GQLDescription("""SHA of the branch being compared against""")
      startSha: String
  )
  @GQLDescription("""Autogenerated input type of EpicAddIssue""")
  case class EpicAddIssueInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The group the epic to mutate belongs to""")
      groupPath: ID,
      @GQLDescription("""The iid of the epic to mutate""")
      iid: ID,
      @GQLDescription("""The iid of the issue to be added""")
      issueIid: String,
      @GQLDescription("""The project the issue belongs to""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of EpicSetSubscription""")
  case class EpicSetSubscriptionInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The group the epic to mutate belongs to""")
      groupPath: ID,
      @GQLDescription("""The iid of the epic to mutate""")
      iid: ID,
      @GQLDescription("""The desired state of the subscription""")
      subscribedState: Boolean
  )
  @GQLDescription("""A node of an epic tree.""")
  case class EpicTreeNodeFieldsInputType(
      @GQLDescription(
        """The id of the epic_issue or issue that the actual epic or issue is switched with"""
      )
      adjacentReferenceId: ID,
      @GQLDescription(
        """The id of the epic_issue or epic that is being moved"""
      )
      id: ID,
      @GQLDescription("""The type of the switch, after or before allowed""")
      relativePosition: MoveType
  )
  @GQLDescription("""Autogenerated input type of EpicTreeReorder""")
  case class EpicTreeReorderInput(
      @GQLDescription("""The id of the base epic of the tree""")
      baseEpicId: ID,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Parameters for updating the tree positions""")
      moved: EpicTreeNodeFieldsInputType
  )
  @GQLDescription("""Autogenerated input type of IssueSetConfidential""")
  case class IssueSetConfidentialInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Whether or not to set the issue as a confidential.""")
      confidential: Boolean,
      @GQLDescription("""The iid of the issue to mutate""")
      iid: ID,
      @GQLDescription("""The project the issue to mutate is in""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of IssueSetDueDate""")
  case class IssueSetDueDateInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The desired due date for the issue""")
      dueDate: Time,
      @GQLDescription("""The iid of the issue to mutate""")
      iid: ID,
      @GQLDescription("""The project the issue to mutate is in""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of IssueSetWeight""")
  case class IssueSetWeightInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the issue to mutate""")
      iid: ID,
      @GQLDescription("""The project the issue to mutate is in""")
      projectPath: ID,
      @GQLDescription("""The desired weight for the issue""")
      weight: Int
  )
  @GQLDescription("""Autogenerated input type of MarkAsSpamSnippet""")
  case class MarkAsSpamSnippetInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the snippet to update""")
      id: ID
  )
  @GQLDescription("""Autogenerated input type of MergeRequestSetAssignees""")
  case class MergeRequestSetAssigneesInput(
      @GQLDescription(
        """The usernames to assign to the merge request. Replaces existing assignees by default."""
      )
      assigneeUsernames: List[String],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the merge request to mutate""")
      iid: ID,
      @GQLDescription("""The operation to perform. Defaults to REPLACE.""")
      operationMode: Option[MutationOperationMode],
      @GQLDescription("""The project the merge request to mutate is in""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of MergeRequestSetLabels""")
  case class MergeRequestSetLabelsInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the merge request to mutate""")
      iid: ID,
      @GQLDescription(
        """The Label IDs to set. Replaces existing labels by default."""
      )
      labelIds: List[ID],
      @GQLDescription("""Changes the operation mode. Defaults to REPLACE.""")
      operationMode: Option[MutationOperationMode],
      @GQLDescription("""The project the merge request to mutate is in""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of MergeRequestSetLocked""")
  case class MergeRequestSetLockedInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the merge request to mutate""")
      iid: ID,
      @GQLDescription("""Whether or not to lock the merge request.""")
      locked: Boolean,
      @GQLDescription("""The project the merge request to mutate is in""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of MergeRequestSetMilestone""")
  case class MergeRequestSetMilestoneInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the merge request to mutate""")
      iid: ID,
      @GQLDescription("""The milestone to assign to the merge request.""")
      milestoneId: Option[ID],
      @GQLDescription("""The project the merge request to mutate is in""")
      projectPath: ID
  )
  @GQLDescription("""Autogenerated input type of MergeRequestSetSubscription""")
  case class MergeRequestSetSubscriptionInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the merge request to mutate""")
      iid: ID,
      @GQLDescription("""The project the merge request to mutate is in""")
      projectPath: ID,
      @GQLDescription("""The desired state of the subscription""")
      subscribedState: Boolean
  )
  @GQLDescription("""Autogenerated input type of MergeRequestSetWip""")
  case class MergeRequestSetWipInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The iid of the merge request to mutate""")
      iid: ID,
      @GQLDescription("""The project the merge request to mutate is in""")
      projectPath: ID,
      @GQLDescription("""Whether or not to set the merge request as a WIP.""")
      wip: Boolean
  )
  @GQLDescription("""Autogenerated input type of RemoveAwardEmoji""")
  case class RemoveAwardEmojiInput(
      @GQLDescription("""The global id of the awardable resource""")
      awardableId: ID,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The emoji name""")
      name: String
  )
  @GQLDescription("""Autogenerated input type of TodoMarkDone""")
  case class TodoMarkDoneInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the todo to mark as done""")
      id: ID
  )
  @GQLDescription("""Autogenerated input type of TodoRestore""")
  case class TodoRestoreInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the todo to restore""")
      id: ID
  )
  @GQLDescription("""Autogenerated input type of TodoRestoreMany""")
  case class TodoRestoreManyInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription(
        """The global ids of the todos to restore (a maximum of 50 is supported at once)"""
      )
      ids: List[ID]
  )
  @GQLDescription("""Autogenerated input type of TodosMarkAllDone""")
  case class TodosMarkAllDoneInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String]
  )
  @GQLDescription("""Autogenerated input type of ToggleAwardEmoji""")
  case class ToggleAwardEmojiInput(
      @GQLDescription("""The global id of the awardable resource""")
      awardableId: ID,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The emoji name""")
      name: String
  )
  case class UpdateDiffImagePositionInput(
      @GQLDescription("""Total height of the image""")
      height: Option[Int],
      @GQLDescription("""Total width of the image""")
      width: Option[Int],
      @GQLDescription("""X position of the note""")
      x: Option[Int],
      @GQLDescription("""Y position of the note""")
      y: Option[Int]
  )
  @GQLDescription("""Autogenerated input type of UpdateEpic""")
  case class UpdateEpicInput(
      @GQLDescription("""The IDs of labels to be added to the epic.""")
      addLabelIds: Option[List[ID]],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The description of the epic""")
      description: Option[String],
      @GQLDescription("""The end date of the epic""")
      dueDateFixed: Option[String],
      @GQLDescription(
        """Indicates end date should be sourced from due_date_fixed field not the issue milestones"""
      )
      dueDateIsFixed: Option[Boolean],
      @GQLDescription("""The group the epic to mutate is in""")
      groupPath: ID,
      @GQLDescription("""The iid of the epic to mutate""")
      iid: ID,
      @GQLDescription("""The IDs of labels to be removed from the epic.""")
      removeLabelIds: Option[List[ID]],
      @GQLDescription("""The start date of the epic""")
      startDateFixed: Option[String],
      @GQLDescription(
        """Indicates start date should be sourced from start_date_fixed field not the issue milestones"""
      )
      startDateIsFixed: Option[Boolean],
      @GQLDescription("""State event for the epic""")
      stateEvent: Option[EpicStateEvent],
      @GQLDescription("""The title of the epic""")
      title: Option[String]
  )
  @GQLDescription("""Autogenerated input type of UpdateImageDiffNote""")
  case class UpdateImageDiffNoteInput(
      @GQLDescription("""Content of the note""")
      body: Option[String],
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the note to update""")
      id: ID,
      @GQLDescription("""The position of this note on a diff""")
      position: Option[UpdateDiffImagePositionInput]
  )
  @GQLDescription("""Autogenerated input type of UpdateIssue""")
  case class UpdateIssueInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Indicates the issue is confidential""")
      confidential: Option[Boolean],
      @GQLDescription("""Description of the issue""")
      description: Option[String],
      @GQLDescription("""Due date of the issue""")
      dueDate: Option[Time],
      @GQLDescription("""The desired health status""")
      healthStatus: Option[HealthStatus],
      @GQLDescription("""The iid of the issue to mutate""")
      iid: ID,
      @GQLDescription("""The project the issue to mutate is in""")
      projectPath: ID,
      @GQLDescription("""Title of the issue""")
      title: Option[String]
  )
  @GQLDescription("""Autogenerated input type of UpdateNote""")
  case class UpdateNoteInput(
      @GQLDescription("""Content of the note""")
      body: String,
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""The global id of the note to update""")
      id: ID
  )
  @GQLDescription("""Autogenerated input type of UpdateSnippet""")
  case class UpdateSnippetInput(
      @GQLDescription(
        """A unique identifier for the client performing the mutation."""
      )
      clientMutationId: Option[String],
      @GQLDescription("""Content of the snippet""")
      content: Option[String],
      @GQLDescription("""Description of the snippet""")
      description: Option[String],
      @GQLDescription("""File name of the snippet""")
      fileName: Option[String],
      @GQLDescription("""The global id of the snippet to update""")
      id: ID,
      @GQLDescription("""Title of the snippet""")
      title: Option[String],
      @GQLDescription("""The visibility level of the snippet""")
      visibilityLevel: Option[VisibilityLevelsEnum]
  )

  @GQLDescription("""Types of blob viewers""")
  sealed trait BlobViewersType extends scala.Product with scala.Serializable

  object BlobViewersType {
    case object auxiliary extends BlobViewersType
    case object rich extends BlobViewersType
    case object simple extends BlobViewersType
  }

  @GQLDescription("""Mutation event of a design within a version""")
  sealed trait DesignVersionEvent extends scala.Product with scala.Serializable

  object DesignVersionEvent {
    @GQLDescription("""A creation event""")
    case object CREATION extends DesignVersionEvent
    @GQLDescription("""A deletion event""")
    case object DELETION extends DesignVersionEvent
    @GQLDescription("""A modification event""")
    case object MODIFICATION extends DesignVersionEvent
    @GQLDescription("""No change""")
    case object NONE extends DesignVersionEvent
  }

  @GQLDescription("""Type of file the position refers to""")
  sealed trait DiffPositionType extends scala.Product with scala.Serializable

  object DiffPositionType {
    case object image extends DiffPositionType
    case object text extends DiffPositionType
  }

  @GQLDescription("""Type of a tree entry""")
  sealed trait EntryType extends scala.Product with scala.Serializable

  object EntryType {
    case object blob extends EntryType
    case object commit extends EntryType
    case object tree extends EntryType
  }

  @GQLDescription("""Roadmap sort values""")
  sealed trait EpicSort extends scala.Product with scala.Serializable

  object EpicSort {
    @GQLDescription("""End date at ascending order""")
    case object end_date_asc extends EpicSort
    @GQLDescription("""End date at descending order""")
    case object end_date_desc extends EpicSort
    @GQLDescription("""Start date at ascending order""")
    case object start_date_asc extends EpicSort
    @GQLDescription("""Start date at descending order""")
    case object start_date_desc extends EpicSort
  }

  @GQLDescription("""State of an epic.""")
  sealed trait EpicState extends scala.Product with scala.Serializable

  object EpicState {
    case object all extends EpicState
    case object closed extends EpicState
    case object opened extends EpicState
  }

  @GQLDescription("""State event of an epic""")
  sealed trait EpicStateEvent extends scala.Product with scala.Serializable

  object EpicStateEvent {
    @GQLDescription("""Close the epic""")
    case object CLOSE extends EpicStateEvent
    @GQLDescription("""Reopen the epic""")
    case object REOPEN extends EpicStateEvent
  }

  @GQLDescription("""Health status of an issue or epic""")
  sealed trait HealthStatus extends scala.Product with scala.Serializable

  object HealthStatus {
    case object atRisk extends HealthStatus
    case object needsAttention extends HealthStatus
    case object onTrack extends HealthStatus
  }

  @GQLDescription("""State of a GitLab issue or merge request""")
  sealed trait IssuableState extends scala.Product with scala.Serializable

  object IssuableState {
    case object closed extends IssuableState
    case object locked extends IssuableState
    case object opened extends IssuableState
  }

  @GQLDescription("""Values for sorting issues""")
  sealed trait IssueSort extends scala.Product with scala.Serializable

  object IssueSort {
    @GQLDescription("""Due date by ascending order""")
    case object DUE_DATE_ASC extends IssueSort
    @GQLDescription("""Due date by descending order""")
    case object DUE_DATE_DESC extends IssueSort
    @GQLDescription("""Relative position by ascending order""")
    case object RELATIVE_POSITION_ASC extends IssueSort
    @GQLDescription("""Weight by ascending order""")
    case object WEIGHT_ASC extends IssueSort
    @GQLDescription("""Weight by descending order""")
    case object WEIGHT_DESC extends IssueSort
    @GQLDescription("""Created at ascending order""")
    case object created_asc extends IssueSort
    @GQLDescription("""Created at descending order""")
    case object created_desc extends IssueSort
    @GQLDescription("""Updated at ascending order""")
    case object updated_asc extends IssueSort
    @GQLDescription("""Updated at descending order""")
    case object updated_desc extends IssueSort
  }

  @GQLDescription("""State of a GitLab issue""")
  sealed trait IssueState extends scala.Product with scala.Serializable

  object IssueState {
    case object closed extends IssueState
    case object locked extends IssueState
    case object opened extends IssueState
  }

  @GQLDescription("""State of a GitLab merge request""")
  sealed trait MergeRequestState extends scala.Product with scala.Serializable

  object MergeRequestState {
    case object closed extends MergeRequestState
    case object locked extends MergeRequestState
    case object merged extends MergeRequestState
    case object opened extends MergeRequestState
  }

  sealed trait MilestoneStateEnum extends scala.Product with scala.Serializable

  object MilestoneStateEnum {
    case object active extends MilestoneStateEnum
    case object closed extends MilestoneStateEnum
  }

  @GQLDescription(
    """The position to which the adjacent object should be moved"""
  )
  sealed trait MoveType extends scala.Product with scala.Serializable

  object MoveType {
    @GQLDescription(
      """The adjacent object will be moved after the object that is being moved"""
    )
    case object after extends MoveType
    @GQLDescription(
      """The adjacent object will be moved before the object that is being moved"""
    )
    case object before extends MoveType
  }

  @GQLDescription("""Different toggles for changing mutator behavior.""")
  sealed trait MutationOperationMode
      extends scala.Product
      with scala.Serializable

  object MutationOperationMode {
    @GQLDescription("""Performs an append operation""")
    case object APPEND extends MutationOperationMode
    @GQLDescription("""Performs a removal operation""")
    case object REMOVE extends MutationOperationMode
    @GQLDescription("""Performs a replace operation""")
    case object REPLACE extends MutationOperationMode
  }

  sealed trait PipelineStatusEnum extends scala.Product with scala.Serializable

  object PipelineStatusEnum {
    case object CANCELED extends PipelineStatusEnum
    case object CREATED extends PipelineStatusEnum
    case object FAILED extends PipelineStatusEnum
    case object MANUAL extends PipelineStatusEnum
    case object PENDING extends PipelineStatusEnum
    case object PREPARING extends PipelineStatusEnum
    case object RUNNING extends PipelineStatusEnum
    case object SCHEDULED extends PipelineStatusEnum
    case object SKIPPED extends PipelineStatusEnum
    case object SUCCESS extends PipelineStatusEnum
    case object WAITING_FOR_RESOURCE extends PipelineStatusEnum
  }

  @GQLDescription("""State of a Sentry error""")
  sealed trait SentryErrorStatus extends scala.Product with scala.Serializable

  object SentryErrorStatus {
    @GQLDescription("""Error has been ignored""")
    case object IGNORED extends SentryErrorStatus
    @GQLDescription("""Error has been resolved""")
    case object RESOLVED extends SentryErrorStatus
    @GQLDescription("""Error has been ignored until next release""")
    case object RESOLVED_IN_NEXT_RELEASE extends SentryErrorStatus
    @GQLDescription("""Error is unresolved""")
    case object UNRESOLVED extends SentryErrorStatus
  }

  sealed trait TodoActionEnum extends scala.Product with scala.Serializable

  object TodoActionEnum {
    case object approval_required extends TodoActionEnum
    case object assigned extends TodoActionEnum
    case object build_failed extends TodoActionEnum
    case object directly_addressed extends TodoActionEnum
    case object marked extends TodoActionEnum
    case object mentioned extends TodoActionEnum
    case object unmergeable extends TodoActionEnum
  }

  sealed trait TodoStateEnum extends scala.Product with scala.Serializable

  object TodoStateEnum {
    case object done extends TodoStateEnum
    case object pending extends TodoStateEnum
  }

  sealed trait TodoTargetEnum extends scala.Product with scala.Serializable

  object TodoTargetEnum {
    @GQLDescription("""A Commit""")
    case object COMMIT extends TodoTargetEnum
    @GQLDescription("""A Design""")
    case object DESIGN extends TodoTargetEnum
    @GQLDescription("""An Epic""")
    case object EPIC extends TodoTargetEnum
    @GQLDescription("""An Issue""")
    case object ISSUE extends TodoTargetEnum
    @GQLDescription("""A MergeRequest""")
    case object MERGEREQUEST extends TodoTargetEnum
  }

  sealed trait TypeEnum extends scala.Product with scala.Serializable

  object TypeEnum {
    case object personal extends TypeEnum
    case object project extends TypeEnum
  }

  sealed trait VisibilityLevelsEnum
      extends scala.Product
      with scala.Serializable

  object VisibilityLevelsEnum {
    case object internal extends VisibilityLevelsEnum
    case object `private` extends VisibilityLevelsEnum
    case object public extends VisibilityLevelsEnum
  }

  sealed trait VisibilityScopesEnum
      extends scala.Product
      with scala.Serializable

  object VisibilityScopesEnum {
    case object internal extends VisibilityScopesEnum
    case object `private` extends VisibilityScopesEnum
    case object public extends VisibilityScopesEnum
  }

}

object Operations {

  case class Query(
      currentUser: () => Option[User],
      designManagement: () => DesignManagement,
      echo: EchoArgs => String,
      group: GroupArgs => Option[Group],
      metadata: () => Option[Metadata],
      namespace: NamespaceArgs => Option[Namespace],
      project: ProjectArgs => Option[Project],
      snippets: SnippetsArgs => Option[SnippetConnection]
  )

  case class Mutation(
      addAwardEmoji: AddAwardEmojiArgs => Option[AddAwardEmojiPayload],
      adminSidekiqQueuesDeleteJobs: AdminSidekiqQueuesDeleteJobsArgs => Option[
        AdminSidekiqQueuesDeleteJobsPayload
      ],
      createDiffNote: CreateDiffNoteArgs => Option[CreateDiffNotePayload],
      createEpic: CreateEpicArgs => Option[CreateEpicPayload],
      createImageDiffNote: CreateImageDiffNoteArgs => Option[
        CreateImageDiffNotePayload
      ],
      createNote: CreateNoteArgs => Option[CreateNotePayload],
      createSnippet: CreateSnippetArgs => Option[CreateSnippetPayload],
      designManagementDelete: DesignManagementDeleteArgs => Option[
        DesignManagementDeletePayload
      ],
      designManagementUpload: DesignManagementUploadArgs => Option[
        DesignManagementUploadPayload
      ],
      destroyNote: DestroyNoteArgs => Option[DestroyNotePayload],
      destroySnippet: DestroySnippetArgs => Option[DestroySnippetPayload],
      epicAddIssue: EpicAddIssueArgs => Option[EpicAddIssuePayload],
      epicSetSubscription: EpicSetSubscriptionArgs => Option[
        EpicSetSubscriptionPayload
      ],
      epicTreeReorder: EpicTreeReorderArgs => Option[EpicTreeReorderPayload],
      issueSetConfidential: IssueSetConfidentialArgs => Option[
        IssueSetConfidentialPayload
      ],
      issueSetDueDate: IssueSetDueDateArgs => Option[IssueSetDueDatePayload],
      issueSetWeight: IssueSetWeightArgs => Option[IssueSetWeightPayload],
      markAsSpamSnippet: MarkAsSpamSnippetArgs => Option[
        MarkAsSpamSnippetPayload
      ],
      mergeRequestSetAssignees: MergeRequestSetAssigneesArgs => Option[
        MergeRequestSetAssigneesPayload
      ],
      mergeRequestSetLabels: MergeRequestSetLabelsArgs => Option[
        MergeRequestSetLabelsPayload
      ],
      mergeRequestSetLocked: MergeRequestSetLockedArgs => Option[
        MergeRequestSetLockedPayload
      ],
      mergeRequestSetMilestone: MergeRequestSetMilestoneArgs => Option[
        MergeRequestSetMilestonePayload
      ],
      mergeRequestSetSubscription: MergeRequestSetSubscriptionArgs => Option[
        MergeRequestSetSubscriptionPayload
      ],
      mergeRequestSetWip: MergeRequestSetWipArgs => Option[
        MergeRequestSetWipPayload
      ],
      removeAwardEmoji: RemoveAwardEmojiArgs => Option[RemoveAwardEmojiPayload],
      todoMarkDone: TodoMarkDoneArgs => Option[TodoMarkDonePayload],
      todoRestore: TodoRestoreArgs => Option[TodoRestorePayload],
      todoRestoreMany: TodoRestoreManyArgs => Option[TodoRestoreManyPayload],
      todosMarkAllDone: TodosMarkAllDoneArgs => Option[TodosMarkAllDonePayload],
      toggleAwardEmoji: ToggleAwardEmojiArgs => Option[ToggleAwardEmojiPayload],
      updateEpic: UpdateEpicArgs => Option[UpdateEpicPayload],
      updateImageDiffNote: UpdateImageDiffNoteArgs => Option[
        UpdateImageDiffNotePayload
      ],
      updateIssue: UpdateIssueArgs => Option[UpdateIssuePayload],
      updateNote: UpdateNoteArgs => Option[UpdateNotePayload],
      updateSnippet: UpdateSnippetArgs => Option[UpdateSnippetPayload]
  )

}
