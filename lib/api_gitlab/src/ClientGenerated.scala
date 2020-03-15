import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client.SelectionBuilder._
import caliban.client._
import caliban.client.Operations._
import caliban.client.Value._

object Client {

  type Time = String

  type Upload = String

  sealed trait BlobViewersType extends scala.Product with scala.Serializable
  object BlobViewersType {
    case object auxiliary extends BlobViewersType
    case object rich extends BlobViewersType
    case object simple extends BlobViewersType

    implicit val decoder: ScalarDecoder[BlobViewersType] = {
      case StringValue("auxiliary") => Right(BlobViewersType.auxiliary)
      case StringValue("rich")      => Right(BlobViewersType.rich)
      case StringValue("simple")    => Right(BlobViewersType.simple)
      case other =>
        Left(DecodingError(s"Can't build BlobViewersType from input $other"))
    }
    implicit val encoder: ArgEncoder[BlobViewersType] =
      new ArgEncoder[BlobViewersType] {
        override def encode(value: BlobViewersType): Value = value match {
          case BlobViewersType.auxiliary => EnumValue("auxiliary")
          case BlobViewersType.rich      => EnumValue("rich")
          case BlobViewersType.simple    => EnumValue("simple")
        }
        override def typeName: String = "BlobViewersType"
      }
  }

  sealed trait DesignVersionEvent extends scala.Product with scala.Serializable
  object DesignVersionEvent {
    case object CREATION extends DesignVersionEvent
    case object DELETION extends DesignVersionEvent
    case object MODIFICATION extends DesignVersionEvent
    case object NONE extends DesignVersionEvent

    implicit val decoder: ScalarDecoder[DesignVersionEvent] = {
      case StringValue("CREATION")     => Right(DesignVersionEvent.CREATION)
      case StringValue("DELETION")     => Right(DesignVersionEvent.DELETION)
      case StringValue("MODIFICATION") => Right(DesignVersionEvent.MODIFICATION)
      case StringValue("NONE")         => Right(DesignVersionEvent.NONE)
      case other =>
        Left(DecodingError(s"Can't build DesignVersionEvent from input $other"))
    }
    implicit val encoder: ArgEncoder[DesignVersionEvent] =
      new ArgEncoder[DesignVersionEvent] {
        override def encode(value: DesignVersionEvent): Value = value match {
          case DesignVersionEvent.CREATION     => EnumValue("CREATION")
          case DesignVersionEvent.DELETION     => EnumValue("DELETION")
          case DesignVersionEvent.MODIFICATION => EnumValue("MODIFICATION")
          case DesignVersionEvent.NONE         => EnumValue("NONE")
        }
        override def typeName: String = "DesignVersionEvent"
      }
  }

  sealed trait DiffPositionType extends scala.Product with scala.Serializable
  object DiffPositionType {
    case object image extends DiffPositionType
    case object text extends DiffPositionType

    implicit val decoder: ScalarDecoder[DiffPositionType] = {
      case StringValue("image") => Right(DiffPositionType.image)
      case StringValue("text")  => Right(DiffPositionType.text)
      case other =>
        Left(DecodingError(s"Can't build DiffPositionType from input $other"))
    }
    implicit val encoder: ArgEncoder[DiffPositionType] =
      new ArgEncoder[DiffPositionType] {
        override def encode(value: DiffPositionType): Value = value match {
          case DiffPositionType.image => EnumValue("image")
          case DiffPositionType.text  => EnumValue("text")
        }
        override def typeName: String = "DiffPositionType"
      }
  }

  sealed trait EntryType extends scala.Product with scala.Serializable
  object EntryType {
    case object blob extends EntryType
    case object commit extends EntryType
    case object tree extends EntryType

    implicit val decoder: ScalarDecoder[EntryType] = {
      case StringValue("blob")   => Right(EntryType.blob)
      case StringValue("commit") => Right(EntryType.commit)
      case StringValue("tree")   => Right(EntryType.tree)
      case other =>
        Left(DecodingError(s"Can't build EntryType from input $other"))
    }
    implicit val encoder: ArgEncoder[EntryType] = new ArgEncoder[EntryType] {
      override def encode(value: EntryType): Value = value match {
        case EntryType.blob   => EnumValue("blob")
        case EntryType.commit => EnumValue("commit")
        case EntryType.tree   => EnumValue("tree")
      }
      override def typeName: String = "EntryType"
    }
  }

  sealed trait EpicSort extends scala.Product with scala.Serializable
  object EpicSort {
    case object end_date_asc extends EpicSort
    case object end_date_desc extends EpicSort
    case object start_date_asc extends EpicSort
    case object start_date_desc extends EpicSort

    implicit val decoder: ScalarDecoder[EpicSort] = {
      case StringValue("end_date_asc")    => Right(EpicSort.end_date_asc)
      case StringValue("end_date_desc")   => Right(EpicSort.end_date_desc)
      case StringValue("start_date_asc")  => Right(EpicSort.start_date_asc)
      case StringValue("start_date_desc") => Right(EpicSort.start_date_desc)
      case other =>
        Left(DecodingError(s"Can't build EpicSort from input $other"))
    }
    implicit val encoder: ArgEncoder[EpicSort] = new ArgEncoder[EpicSort] {
      override def encode(value: EpicSort): Value = value match {
        case EpicSort.end_date_asc    => EnumValue("end_date_asc")
        case EpicSort.end_date_desc   => EnumValue("end_date_desc")
        case EpicSort.start_date_asc  => EnumValue("start_date_asc")
        case EpicSort.start_date_desc => EnumValue("start_date_desc")
      }
      override def typeName: String = "EpicSort"
    }
  }

  sealed trait EpicState extends scala.Product with scala.Serializable
  object EpicState {
    case object all extends EpicState
    case object closed extends EpicState
    case object opened extends EpicState

    implicit val decoder: ScalarDecoder[EpicState] = {
      case StringValue("all")    => Right(EpicState.all)
      case StringValue("closed") => Right(EpicState.closed)
      case StringValue("opened") => Right(EpicState.opened)
      case other =>
        Left(DecodingError(s"Can't build EpicState from input $other"))
    }
    implicit val encoder: ArgEncoder[EpicState] = new ArgEncoder[EpicState] {
      override def encode(value: EpicState): Value = value match {
        case EpicState.all    => EnumValue("all")
        case EpicState.closed => EnumValue("closed")
        case EpicState.opened => EnumValue("opened")
      }
      override def typeName: String = "EpicState"
    }
  }

  sealed trait EpicStateEvent extends scala.Product with scala.Serializable
  object EpicStateEvent {
    case object CLOSE extends EpicStateEvent
    case object REOPEN extends EpicStateEvent

    implicit val decoder: ScalarDecoder[EpicStateEvent] = {
      case StringValue("CLOSE")  => Right(EpicStateEvent.CLOSE)
      case StringValue("REOPEN") => Right(EpicStateEvent.REOPEN)
      case other =>
        Left(DecodingError(s"Can't build EpicStateEvent from input $other"))
    }
    implicit val encoder: ArgEncoder[EpicStateEvent] =
      new ArgEncoder[EpicStateEvent] {
        override def encode(value: EpicStateEvent): Value = value match {
          case EpicStateEvent.CLOSE  => EnumValue("CLOSE")
          case EpicStateEvent.REOPEN => EnumValue("REOPEN")
        }
        override def typeName: String = "EpicStateEvent"
      }
  }

  sealed trait HealthStatus extends scala.Product with scala.Serializable
  object HealthStatus {
    case object atRisk extends HealthStatus
    case object needsAttention extends HealthStatus
    case object onTrack extends HealthStatus

    implicit val decoder: ScalarDecoder[HealthStatus] = {
      case StringValue("atRisk")         => Right(HealthStatus.atRisk)
      case StringValue("needsAttention") => Right(HealthStatus.needsAttention)
      case StringValue("onTrack")        => Right(HealthStatus.onTrack)
      case other =>
        Left(DecodingError(s"Can't build HealthStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[HealthStatus] =
      new ArgEncoder[HealthStatus] {
        override def encode(value: HealthStatus): Value = value match {
          case HealthStatus.atRisk         => EnumValue("atRisk")
          case HealthStatus.needsAttention => EnumValue("needsAttention")
          case HealthStatus.onTrack        => EnumValue("onTrack")
        }
        override def typeName: String = "HealthStatus"
      }
  }

  sealed trait IssuableState extends scala.Product with scala.Serializable
  object IssuableState {
    case object closed extends IssuableState
    case object locked extends IssuableState
    case object opened extends IssuableState

    implicit val decoder: ScalarDecoder[IssuableState] = {
      case StringValue("closed") => Right(IssuableState.closed)
      case StringValue("locked") => Right(IssuableState.locked)
      case StringValue("opened") => Right(IssuableState.opened)
      case other =>
        Left(DecodingError(s"Can't build IssuableState from input $other"))
    }
    implicit val encoder: ArgEncoder[IssuableState] =
      new ArgEncoder[IssuableState] {
        override def encode(value: IssuableState): Value = value match {
          case IssuableState.closed => EnumValue("closed")
          case IssuableState.locked => EnumValue("locked")
          case IssuableState.opened => EnumValue("opened")
        }
        override def typeName: String = "IssuableState"
      }
  }

  sealed trait IssueSort extends scala.Product with scala.Serializable
  object IssueSort {
    case object DUE_DATE_ASC extends IssueSort
    case object DUE_DATE_DESC extends IssueSort
    case object RELATIVE_POSITION_ASC extends IssueSort
    case object WEIGHT_ASC extends IssueSort
    case object WEIGHT_DESC extends IssueSort
    case object created_asc extends IssueSort
    case object created_desc extends IssueSort
    case object updated_asc extends IssueSort
    case object updated_desc extends IssueSort

    implicit val decoder: ScalarDecoder[IssueSort] = {
      case StringValue("DUE_DATE_ASC")  => Right(IssueSort.DUE_DATE_ASC)
      case StringValue("DUE_DATE_DESC") => Right(IssueSort.DUE_DATE_DESC)
      case StringValue("RELATIVE_POSITION_ASC") =>
        Right(IssueSort.RELATIVE_POSITION_ASC)
      case StringValue("WEIGHT_ASC")   => Right(IssueSort.WEIGHT_ASC)
      case StringValue("WEIGHT_DESC")  => Right(IssueSort.WEIGHT_DESC)
      case StringValue("created_asc")  => Right(IssueSort.created_asc)
      case StringValue("created_desc") => Right(IssueSort.created_desc)
      case StringValue("updated_asc")  => Right(IssueSort.updated_asc)
      case StringValue("updated_desc") => Right(IssueSort.updated_desc)
      case other =>
        Left(DecodingError(s"Can't build IssueSort from input $other"))
    }
    implicit val encoder: ArgEncoder[IssueSort] = new ArgEncoder[IssueSort] {
      override def encode(value: IssueSort): Value = value match {
        case IssueSort.DUE_DATE_ASC  => EnumValue("DUE_DATE_ASC")
        case IssueSort.DUE_DATE_DESC => EnumValue("DUE_DATE_DESC")
        case IssueSort.RELATIVE_POSITION_ASC =>
          EnumValue("RELATIVE_POSITION_ASC")
        case IssueSort.WEIGHT_ASC   => EnumValue("WEIGHT_ASC")
        case IssueSort.WEIGHT_DESC  => EnumValue("WEIGHT_DESC")
        case IssueSort.created_asc  => EnumValue("created_asc")
        case IssueSort.created_desc => EnumValue("created_desc")
        case IssueSort.updated_asc  => EnumValue("updated_asc")
        case IssueSort.updated_desc => EnumValue("updated_desc")
      }
      override def typeName: String = "IssueSort"
    }
  }

  sealed trait IssueState extends scala.Product with scala.Serializable
  object IssueState {
    case object closed extends IssueState
    case object locked extends IssueState
    case object opened extends IssueState

    implicit val decoder: ScalarDecoder[IssueState] = {
      case StringValue("closed") => Right(IssueState.closed)
      case StringValue("locked") => Right(IssueState.locked)
      case StringValue("opened") => Right(IssueState.opened)
      case other =>
        Left(DecodingError(s"Can't build IssueState from input $other"))
    }
    implicit val encoder: ArgEncoder[IssueState] = new ArgEncoder[IssueState] {
      override def encode(value: IssueState): Value = value match {
        case IssueState.closed => EnumValue("closed")
        case IssueState.locked => EnumValue("locked")
        case IssueState.opened => EnumValue("opened")
      }
      override def typeName: String = "IssueState"
    }
  }

  sealed trait MergeRequestState extends scala.Product with scala.Serializable
  object MergeRequestState {
    case object closed extends MergeRequestState
    case object locked extends MergeRequestState
    case object merged extends MergeRequestState
    case object opened extends MergeRequestState

    implicit val decoder: ScalarDecoder[MergeRequestState] = {
      case StringValue("closed") => Right(MergeRequestState.closed)
      case StringValue("locked") => Right(MergeRequestState.locked)
      case StringValue("merged") => Right(MergeRequestState.merged)
      case StringValue("opened") => Right(MergeRequestState.opened)
      case other =>
        Left(DecodingError(s"Can't build MergeRequestState from input $other"))
    }
    implicit val encoder: ArgEncoder[MergeRequestState] =
      new ArgEncoder[MergeRequestState] {
        override def encode(value: MergeRequestState): Value = value match {
          case MergeRequestState.closed => EnumValue("closed")
          case MergeRequestState.locked => EnumValue("locked")
          case MergeRequestState.merged => EnumValue("merged")
          case MergeRequestState.opened => EnumValue("opened")
        }
        override def typeName: String = "MergeRequestState"
      }
  }

  sealed trait MilestoneStateEnum extends scala.Product with scala.Serializable
  object MilestoneStateEnum {
    case object active extends MilestoneStateEnum
    case object closed extends MilestoneStateEnum

    implicit val decoder: ScalarDecoder[MilestoneStateEnum] = {
      case StringValue("active") => Right(MilestoneStateEnum.active)
      case StringValue("closed") => Right(MilestoneStateEnum.closed)
      case other =>
        Left(DecodingError(s"Can't build MilestoneStateEnum from input $other"))
    }
    implicit val encoder: ArgEncoder[MilestoneStateEnum] =
      new ArgEncoder[MilestoneStateEnum] {
        override def encode(value: MilestoneStateEnum): Value = value match {
          case MilestoneStateEnum.active => EnumValue("active")
          case MilestoneStateEnum.closed => EnumValue("closed")
        }
        override def typeName: String = "MilestoneStateEnum"
      }
  }

  sealed trait MoveType extends scala.Product with scala.Serializable
  object MoveType {
    case object after extends MoveType
    case object before extends MoveType

    implicit val decoder: ScalarDecoder[MoveType] = {
      case StringValue("after")  => Right(MoveType.after)
      case StringValue("before") => Right(MoveType.before)
      case other =>
        Left(DecodingError(s"Can't build MoveType from input $other"))
    }
    implicit val encoder: ArgEncoder[MoveType] = new ArgEncoder[MoveType] {
      override def encode(value: MoveType): Value = value match {
        case MoveType.after  => EnumValue("after")
        case MoveType.before => EnumValue("before")
      }
      override def typeName: String = "MoveType"
    }
  }

  sealed trait MutationOperationMode
      extends scala.Product
      with scala.Serializable
  object MutationOperationMode {
    case object APPEND extends MutationOperationMode
    case object REMOVE extends MutationOperationMode
    case object REPLACE extends MutationOperationMode

    implicit val decoder: ScalarDecoder[MutationOperationMode] = {
      case StringValue("APPEND")  => Right(MutationOperationMode.APPEND)
      case StringValue("REMOVE")  => Right(MutationOperationMode.REMOVE)
      case StringValue("REPLACE") => Right(MutationOperationMode.REPLACE)
      case other =>
        Left(
          DecodingError(s"Can't build MutationOperationMode from input $other")
        )
    }
    implicit val encoder: ArgEncoder[MutationOperationMode] =
      new ArgEncoder[MutationOperationMode] {
        override def encode(value: MutationOperationMode): Value = value match {
          case MutationOperationMode.APPEND  => EnumValue("APPEND")
          case MutationOperationMode.REMOVE  => EnumValue("REMOVE")
          case MutationOperationMode.REPLACE => EnumValue("REPLACE")
        }
        override def typeName: String = "MutationOperationMode"
      }
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

    implicit val decoder: ScalarDecoder[PipelineStatusEnum] = {
      case StringValue("CANCELED")  => Right(PipelineStatusEnum.CANCELED)
      case StringValue("CREATED")   => Right(PipelineStatusEnum.CREATED)
      case StringValue("FAILED")    => Right(PipelineStatusEnum.FAILED)
      case StringValue("MANUAL")    => Right(PipelineStatusEnum.MANUAL)
      case StringValue("PENDING")   => Right(PipelineStatusEnum.PENDING)
      case StringValue("PREPARING") => Right(PipelineStatusEnum.PREPARING)
      case StringValue("RUNNING")   => Right(PipelineStatusEnum.RUNNING)
      case StringValue("SCHEDULED") => Right(PipelineStatusEnum.SCHEDULED)
      case StringValue("SKIPPED")   => Right(PipelineStatusEnum.SKIPPED)
      case StringValue("SUCCESS")   => Right(PipelineStatusEnum.SUCCESS)
      case StringValue("WAITING_FOR_RESOURCE") =>
        Right(PipelineStatusEnum.WAITING_FOR_RESOURCE)
      case other =>
        Left(DecodingError(s"Can't build PipelineStatusEnum from input $other"))
    }
    implicit val encoder: ArgEncoder[PipelineStatusEnum] =
      new ArgEncoder[PipelineStatusEnum] {
        override def encode(value: PipelineStatusEnum): Value = value match {
          case PipelineStatusEnum.CANCELED  => EnumValue("CANCELED")
          case PipelineStatusEnum.CREATED   => EnumValue("CREATED")
          case PipelineStatusEnum.FAILED    => EnumValue("FAILED")
          case PipelineStatusEnum.MANUAL    => EnumValue("MANUAL")
          case PipelineStatusEnum.PENDING   => EnumValue("PENDING")
          case PipelineStatusEnum.PREPARING => EnumValue("PREPARING")
          case PipelineStatusEnum.RUNNING   => EnumValue("RUNNING")
          case PipelineStatusEnum.SCHEDULED => EnumValue("SCHEDULED")
          case PipelineStatusEnum.SKIPPED   => EnumValue("SKIPPED")
          case PipelineStatusEnum.SUCCESS   => EnumValue("SUCCESS")
          case PipelineStatusEnum.WAITING_FOR_RESOURCE =>
            EnumValue("WAITING_FOR_RESOURCE")
        }
        override def typeName: String = "PipelineStatusEnum"
      }
  }

  sealed trait SentryErrorStatus extends scala.Product with scala.Serializable
  object SentryErrorStatus {
    case object IGNORED extends SentryErrorStatus
    case object RESOLVED extends SentryErrorStatus
    case object RESOLVED_IN_NEXT_RELEASE extends SentryErrorStatus
    case object UNRESOLVED extends SentryErrorStatus

    implicit val decoder: ScalarDecoder[SentryErrorStatus] = {
      case StringValue("IGNORED")  => Right(SentryErrorStatus.IGNORED)
      case StringValue("RESOLVED") => Right(SentryErrorStatus.RESOLVED)
      case StringValue("RESOLVED_IN_NEXT_RELEASE") =>
        Right(SentryErrorStatus.RESOLVED_IN_NEXT_RELEASE)
      case StringValue("UNRESOLVED") => Right(SentryErrorStatus.UNRESOLVED)
      case other =>
        Left(DecodingError(s"Can't build SentryErrorStatus from input $other"))
    }
    implicit val encoder: ArgEncoder[SentryErrorStatus] =
      new ArgEncoder[SentryErrorStatus] {
        override def encode(value: SentryErrorStatus): Value = value match {
          case SentryErrorStatus.IGNORED  => EnumValue("IGNORED")
          case SentryErrorStatus.RESOLVED => EnumValue("RESOLVED")
          case SentryErrorStatus.RESOLVED_IN_NEXT_RELEASE =>
            EnumValue("RESOLVED_IN_NEXT_RELEASE")
          case SentryErrorStatus.UNRESOLVED => EnumValue("UNRESOLVED")
        }
        override def typeName: String = "SentryErrorStatus"
      }
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

    implicit val decoder: ScalarDecoder[TodoActionEnum] = {
      case StringValue("approval_required") =>
        Right(TodoActionEnum.approval_required)
      case StringValue("assigned")     => Right(TodoActionEnum.assigned)
      case StringValue("build_failed") => Right(TodoActionEnum.build_failed)
      case StringValue("directly_addressed") =>
        Right(TodoActionEnum.directly_addressed)
      case StringValue("marked")      => Right(TodoActionEnum.marked)
      case StringValue("mentioned")   => Right(TodoActionEnum.mentioned)
      case StringValue("unmergeable") => Right(TodoActionEnum.unmergeable)
      case other =>
        Left(DecodingError(s"Can't build TodoActionEnum from input $other"))
    }
    implicit val encoder: ArgEncoder[TodoActionEnum] =
      new ArgEncoder[TodoActionEnum] {
        override def encode(value: TodoActionEnum): Value = value match {
          case TodoActionEnum.approval_required =>
            EnumValue("approval_required")
          case TodoActionEnum.assigned     => EnumValue("assigned")
          case TodoActionEnum.build_failed => EnumValue("build_failed")
          case TodoActionEnum.directly_addressed =>
            EnumValue("directly_addressed")
          case TodoActionEnum.marked      => EnumValue("marked")
          case TodoActionEnum.mentioned   => EnumValue("mentioned")
          case TodoActionEnum.unmergeable => EnumValue("unmergeable")
        }
        override def typeName: String = "TodoActionEnum"
      }
  }

  sealed trait TodoStateEnum extends scala.Product with scala.Serializable
  object TodoStateEnum {
    case object done extends TodoStateEnum
    case object pending extends TodoStateEnum

    implicit val decoder: ScalarDecoder[TodoStateEnum] = {
      case StringValue("done")    => Right(TodoStateEnum.done)
      case StringValue("pending") => Right(TodoStateEnum.pending)
      case other =>
        Left(DecodingError(s"Can't build TodoStateEnum from input $other"))
    }
    implicit val encoder: ArgEncoder[TodoStateEnum] =
      new ArgEncoder[TodoStateEnum] {
        override def encode(value: TodoStateEnum): Value = value match {
          case TodoStateEnum.done    => EnumValue("done")
          case TodoStateEnum.pending => EnumValue("pending")
        }
        override def typeName: String = "TodoStateEnum"
      }
  }

  sealed trait TodoTargetEnum extends scala.Product with scala.Serializable
  object TodoTargetEnum {
    case object COMMIT extends TodoTargetEnum
    case object DESIGN extends TodoTargetEnum
    case object EPIC extends TodoTargetEnum
    case object ISSUE extends TodoTargetEnum
    case object MERGEREQUEST extends TodoTargetEnum

    implicit val decoder: ScalarDecoder[TodoTargetEnum] = {
      case StringValue("COMMIT")       => Right(TodoTargetEnum.COMMIT)
      case StringValue("DESIGN")       => Right(TodoTargetEnum.DESIGN)
      case StringValue("EPIC")         => Right(TodoTargetEnum.EPIC)
      case StringValue("ISSUE")        => Right(TodoTargetEnum.ISSUE)
      case StringValue("MERGEREQUEST") => Right(TodoTargetEnum.MERGEREQUEST)
      case other =>
        Left(DecodingError(s"Can't build TodoTargetEnum from input $other"))
    }
    implicit val encoder: ArgEncoder[TodoTargetEnum] =
      new ArgEncoder[TodoTargetEnum] {
        override def encode(value: TodoTargetEnum): Value = value match {
          case TodoTargetEnum.COMMIT       => EnumValue("COMMIT")
          case TodoTargetEnum.DESIGN       => EnumValue("DESIGN")
          case TodoTargetEnum.EPIC         => EnumValue("EPIC")
          case TodoTargetEnum.ISSUE        => EnumValue("ISSUE")
          case TodoTargetEnum.MERGEREQUEST => EnumValue("MERGEREQUEST")
        }
        override def typeName: String = "TodoTargetEnum"
      }
  }

  sealed trait TypeEnum extends scala.Product with scala.Serializable
  object TypeEnum {
    case object personal extends TypeEnum
    case object project extends TypeEnum

    implicit val decoder: ScalarDecoder[TypeEnum] = {
      case StringValue("personal") => Right(TypeEnum.personal)
      case StringValue("project")  => Right(TypeEnum.project)
      case other =>
        Left(DecodingError(s"Can't build TypeEnum from input $other"))
    }
    implicit val encoder: ArgEncoder[TypeEnum] = new ArgEncoder[TypeEnum] {
      override def encode(value: TypeEnum): Value = value match {
        case TypeEnum.personal => EnumValue("personal")
        case TypeEnum.project  => EnumValue("project")
      }
      override def typeName: String = "TypeEnum"
    }
  }

  sealed trait VisibilityLevelsEnum
      extends scala.Product
      with scala.Serializable
  object VisibilityLevelsEnum {
    case object internal extends VisibilityLevelsEnum
    case object `private` extends VisibilityLevelsEnum
    case object public extends VisibilityLevelsEnum

    implicit val decoder: ScalarDecoder[VisibilityLevelsEnum] = {
      case StringValue("internal") => Right(VisibilityLevelsEnum.internal)
      case StringValue("private")  => Right(VisibilityLevelsEnum.`private`)
      case StringValue("public")   => Right(VisibilityLevelsEnum.public)
      case other =>
        Left(
          DecodingError(s"Can't build VisibilityLevelsEnum from input $other")
        )
    }
    implicit val encoder: ArgEncoder[VisibilityLevelsEnum] =
      new ArgEncoder[VisibilityLevelsEnum] {
        override def encode(value: VisibilityLevelsEnum): Value = value match {
          case VisibilityLevelsEnum.internal  => EnumValue("internal")
          case VisibilityLevelsEnum.`private` => EnumValue("private")
          case VisibilityLevelsEnum.public    => EnumValue("public")
        }
        override def typeName: String = "VisibilityLevelsEnum"
      }
  }

  sealed trait VisibilityScopesEnum
      extends scala.Product
      with scala.Serializable
  object VisibilityScopesEnum {
    case object internal extends VisibilityScopesEnum
    case object `private` extends VisibilityScopesEnum
    case object public extends VisibilityScopesEnum

    implicit val decoder: ScalarDecoder[VisibilityScopesEnum] = {
      case StringValue("internal") => Right(VisibilityScopesEnum.internal)
      case StringValue("private")  => Right(VisibilityScopesEnum.`private`)
      case StringValue("public")   => Right(VisibilityScopesEnum.public)
      case other =>
        Left(
          DecodingError(s"Can't build VisibilityScopesEnum from input $other")
        )
    }
    implicit val encoder: ArgEncoder[VisibilityScopesEnum] =
      new ArgEncoder[VisibilityScopesEnum] {
        override def encode(value: VisibilityScopesEnum): Value = value match {
          case VisibilityScopesEnum.internal  => EnumValue("internal")
          case VisibilityScopesEnum.`private` => EnumValue("private")
          case VisibilityScopesEnum.public    => EnumValue("public")
        }
        override def typeName: String = "VisibilityScopesEnum"
      }
  }

  type AddAwardEmojiPayload
  object AddAwardEmojiPayload {

    /**
      * The award emoji after mutation
      */
    def awardEmoji[A](
        innerSelection: SelectionBuilder[AwardEmoji, A]
    ): SelectionBuilder[AddAwardEmojiPayload, Option[A]] =
      Field("awardEmoji", OptionOf(Obj(innerSelection)))

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[AddAwardEmojiPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[AddAwardEmojiPayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type AdminSidekiqQueuesDeleteJobsPayload
  object AdminSidekiqQueuesDeleteJobsPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[AdminSidekiqQueuesDeleteJobsPayload, Option[
          String
        ]] = Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors
        : SelectionBuilder[AdminSidekiqQueuesDeleteJobsPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * Information about the status of the deletion request
      */
    def result[A](
        innerSelection: SelectionBuilder[DeleteJobsResponse, A]
    ): SelectionBuilder[AdminSidekiqQueuesDeleteJobsPayload, Option[A]] =
      Field("result", OptionOf(Obj(innerSelection)))
  }

  type AwardEmoji
  object AwardEmoji {

    /**
      * The emoji description
      */
    def description: SelectionBuilder[AwardEmoji, String] =
      Field("description", Scalar())

    /**
      * The emoji as an icon
      */
    def emoji: SelectionBuilder[AwardEmoji, String] = Field("emoji", Scalar())

    /**
      * The emoji name
      */
    def name: SelectionBuilder[AwardEmoji, String] = Field("name", Scalar())

    /**
      * The emoji in unicode
      */
    def unicode: SelectionBuilder[AwardEmoji, String] =
      Field("unicode", Scalar())

    /**
      * The unicode version for this emoji
      */
    def unicodeVersion: SelectionBuilder[AwardEmoji, String] =
      Field("unicodeVersion", Scalar())

    /**
      * The user who awarded the emoji
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[AwardEmoji, A] = Field("user", Obj(innerSelection))
  }

  type Blob
  object Blob {

    /**
      * Flat path of the entry
      */
    def flatPath: SelectionBuilder[Blob, String] = Field("flatPath", Scalar())

    /**
      * ID of the entry
      */
    def id: SelectionBuilder[Blob, String] = Field("id", Scalar())

    /**
      * LFS ID of the blob
      */
    def lfsOid: SelectionBuilder[Blob, Option[String]] =
      Field("lfsOid", OptionOf(Scalar()))

    /**
      * Name of the entry
      */
    def name: SelectionBuilder[Blob, String] = Field("name", Scalar())

    /**
      * Path of the entry
      */
    def path: SelectionBuilder[Blob, String] = Field("path", Scalar())

    /**
      * Last commit sha for the entry
      */
    def sha: SelectionBuilder[Blob, String] = Field("sha", Scalar())

    /**
      * Type of tree entry
      */
    def `type`: SelectionBuilder[Blob, EntryType] = Field("type", Scalar())

    /**
      * Web URL of the blob
      */
    def webUrl: SelectionBuilder[Blob, Option[String]] =
      Field("webUrl", OptionOf(Scalar()))
  }

  type BlobConnection
  object BlobConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[BlobEdge, A]
    ): SelectionBuilder[BlobConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Blob, A]
    ): SelectionBuilder[BlobConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[BlobConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type BlobEdge
  object BlobEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[BlobEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Blob, A]
    ): SelectionBuilder[BlobEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Board
  object Board {

    /**
      * ID (global ID) of the board
      */
    def id: SelectionBuilder[Board, String] = Field("id", Scalar())

    /**
      * Name of the board
      */
    def name: SelectionBuilder[Board, Option[String]] =
      Field("name", OptionOf(Scalar()))

    /**
      * Weight of the board
      */
    def weight: SelectionBuilder[Board, Option[Int]] =
      Field("weight", OptionOf(Scalar()))
  }

  type BoardConnection
  object BoardConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[BoardEdge, A]
    ): SelectionBuilder[BoardConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Board, A]
    ): SelectionBuilder[BoardConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[BoardConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type BoardEdge
  object BoardEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[BoardEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Board, A]
    ): SelectionBuilder[BoardEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Commit
  object Commit {

    /**
      * Author of the commit
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Commit, Option[A]] =
      Field("author", OptionOf(Obj(innerSelection)))

    /**
      * Commit authors gravatar
      */
    def authorGravatar: SelectionBuilder[Commit, Option[String]] =
      Field("authorGravatar", OptionOf(Scalar()))

    /**
      * Commit authors name
      */
    def authorName: SelectionBuilder[Commit, Option[String]] =
      Field("authorName", OptionOf(Scalar()))

    /**
      * Timestamp of when the commit was authored
      */
    def authoredDate: SelectionBuilder[Commit, Option[Time]] =
      Field("authoredDate", OptionOf(Scalar()))

    /**
      * Description of the commit message
      */
    def description: SelectionBuilder[Commit, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * ID (global ID) of the commit
      */
    def id: SelectionBuilder[Commit, String] = Field("id", Scalar())

    /**
      * Latest pipeline of the commit
      */
    @deprecated("Use pipelines", "")
    def latestPipeline[A](
        ref: Option[String] = None,
        sha: Option[String] = None,
        status: Option[PipelineStatusEnum] = None
    )(
        innerSelection: SelectionBuilder[Pipeline, A]
    ): SelectionBuilder[Commit, Option[A]] =
      Field(
        "latestPipeline",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("ref", ref),
          Argument("sha", sha),
          Argument("status", status)
        )
      )

    /**
      * Raw commit message
      */
    def message: SelectionBuilder[Commit, Option[String]] =
      Field("message", OptionOf(Scalar()))

    /**
      * Pipelines of the commit ordered latest first
      */
    def pipelines[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None,
        ref: Option[String] = None,
        sha: Option[String] = None,
        status: Option[PipelineStatusEnum] = None
    )(
        innerSelection: SelectionBuilder[PipelineConnection, A]
    ): SelectionBuilder[Commit, Option[A]] =
      Field(
        "pipelines",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last),
          Argument("ref", ref),
          Argument("sha", sha),
          Argument("status", status)
        )
      )

    /**
      * SHA1 ID of the commit
      */
    def sha: SelectionBuilder[Commit, String] = Field("sha", Scalar())

    /**
      * Rendered HTML of the commit signature
      */
    def signatureHtml: SelectionBuilder[Commit, Option[String]] =
      Field("signatureHtml", OptionOf(Scalar()))

    /**
      * Title of the commit message
      */
    def title: SelectionBuilder[Commit, Option[String]] =
      Field("title", OptionOf(Scalar()))

    /**
      * Web URL of the commit
      */
    def webUrl: SelectionBuilder[Commit, String] = Field("webUrl", Scalar())
  }

  type CreateDiffNotePayload
  object CreateDiffNotePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[CreateDiffNotePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[CreateDiffNotePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The note after mutation
      */
    def note[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[CreateDiffNotePayload, Option[A]] =
      Field("note", OptionOf(Obj(innerSelection)))
  }

  type CreateEpicPayload
  object CreateEpicPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[CreateEpicPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * The created epic
      */
    def epic[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[CreateEpicPayload, Option[A]] =
      Field("epic", OptionOf(Obj(innerSelection)))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[CreateEpicPayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type CreateImageDiffNotePayload
  object CreateImageDiffNotePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[CreateImageDiffNotePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[CreateImageDiffNotePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The note after mutation
      */
    def note[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[CreateImageDiffNotePayload, Option[A]] =
      Field("note", OptionOf(Obj(innerSelection)))
  }

  type CreateNotePayload
  object CreateNotePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[CreateNotePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[CreateNotePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The note after mutation
      */
    def note[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[CreateNotePayload, Option[A]] =
      Field("note", OptionOf(Obj(innerSelection)))
  }

  type CreateSnippetPayload
  object CreateSnippetPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[CreateSnippetPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[CreateSnippetPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The snippet after mutation
      */
    def snippet[A](
        innerSelection: SelectionBuilder[Snippet, A]
    ): SelectionBuilder[CreateSnippetPayload, Option[A]] =
      Field("snippet", OptionOf(Obj(innerSelection)))
  }

  type DeleteJobsResponse
  object DeleteJobsResponse {

    /**
      * Whether or not the entire queue was processed in time; if not, retrying the same request is safe
      */
    def completed: SelectionBuilder[DeleteJobsResponse, Option[Boolean]] =
      Field("completed", OptionOf(Scalar()))

    /**
      * The number of matching jobs deleted
      */
    def deletedJobs: SelectionBuilder[DeleteJobsResponse, Option[Int]] =
      Field("deletedJobs", OptionOf(Scalar()))

    /**
      * The queue size after processing
      */
    def queueSize: SelectionBuilder[DeleteJobsResponse, Option[Int]] =
      Field("queueSize", OptionOf(Scalar()))
  }

  type Design
  object Design {

    /**
      * The diff refs for this design
      */
    def diffRefs[A](
        innerSelection: SelectionBuilder[DiffRefs, A]
    ): SelectionBuilder[Design, A] = Field("diffRefs", Obj(innerSelection))

    /**
      * All discussions on this noteable
      */
    def discussions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DiscussionConnection, A]
    ): SelectionBuilder[Design, A] =
      Field(
        "discussions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * How this design was changed in the current version
      */
    def event: SelectionBuilder[Design, DesignVersionEvent] =
      Field("event", Scalar())

    /**
      * The filename of the design
      */
    def filename: SelectionBuilder[Design, String] = Field("filename", Scalar())

    /**
      * The full path to the design file
      */
    def fullPath: SelectionBuilder[Design, String] = Field("fullPath", Scalar())

    /**
      * The ID of this design
      */
    def id: SelectionBuilder[Design, String] = Field("id", Scalar())

    /**
      * The URL of the image
      */
    def image: SelectionBuilder[Design, String] = Field("image", Scalar())

    /**
      * The issue the design belongs to
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[Design, A] = Field("issue", Obj(innerSelection))

    /**
      * All notes on this noteable
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[Design, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * The total count of user-created notes for this design
      */
    def notesCount: SelectionBuilder[Design, Int] =
      Field("notesCount", Scalar())

    /**
      * The project the design belongs to
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[Design, A] = Field("project", Obj(innerSelection))

    /**
      * All versions related to this design ordered newest first
      */
    def versions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        earlierOrEqualToId: Option[String] = None,
        earlierOrEqualToSha: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DesignVersionConnection, A]
    ): SelectionBuilder[Design, A] =
      Field(
        "versions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("earlierOrEqualToId", earlierOrEqualToId),
          Argument("earlierOrEqualToSha", earlierOrEqualToSha),
          Argument("first", first),
          Argument("last", last)
        )
      )
  }

  type DesignAtVersion
  object DesignAtVersion {

    /**
      * The underlying design.
      */
    def design[A](
        innerSelection: SelectionBuilder[Design, A]
    ): SelectionBuilder[DesignAtVersion, A] =
      Field("design", Obj(innerSelection))

    /**
      * The diff refs for this design
      */
    def diffRefs[A](
        innerSelection: SelectionBuilder[DiffRefs, A]
    ): SelectionBuilder[DesignAtVersion, A] =
      Field("diffRefs", Obj(innerSelection))

    /**
      * How this design was changed in the current version
      */
    def event: SelectionBuilder[DesignAtVersion, DesignVersionEvent] =
      Field("event", Scalar())

    /**
      * The filename of the design
      */
    def filename: SelectionBuilder[DesignAtVersion, String] =
      Field("filename", Scalar())

    /**
      * The full path to the design file
      */
    def fullPath: SelectionBuilder[DesignAtVersion, String] =
      Field("fullPath", Scalar())

    /**
      * The ID of this design
      */
    def id: SelectionBuilder[DesignAtVersion, String] = Field("id", Scalar())

    /**
      * The URL of the image
      */
    def image: SelectionBuilder[DesignAtVersion, String] =
      Field("image", Scalar())

    /**
      * The issue the design belongs to
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[DesignAtVersion, A] =
      Field("issue", Obj(innerSelection))

    /**
      * The total count of user-created notes for this design
      */
    def notesCount: SelectionBuilder[DesignAtVersion, Int] =
      Field("notesCount", Scalar())

    /**
      * The project the design belongs to
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[DesignAtVersion, A] =
      Field("project", Obj(innerSelection))

    /**
      * The version this design-at-versions is pinned to
      */
    def version[A](
        innerSelection: SelectionBuilder[DesignVersion, A]
    ): SelectionBuilder[DesignAtVersion, A] =
      Field("version", Obj(innerSelection))
  }

  type DesignAtVersionConnection
  object DesignAtVersionConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[DesignAtVersionEdge, A]
    ): SelectionBuilder[DesignAtVersionConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[DesignAtVersion, A]
    ): SelectionBuilder[DesignAtVersionConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[DesignAtVersionConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type DesignAtVersionEdge
  object DesignAtVersionEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[DesignAtVersionEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[DesignAtVersion, A]
    ): SelectionBuilder[DesignAtVersionEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type DesignCollection
  object DesignCollection {

    /**
      * Find a specific design
      */
    def design[A](filename: Option[String] = None, id: Option[String] = None)(
        innerSelection: SelectionBuilder[Design, A]
    ): SelectionBuilder[DesignCollection, Option[A]] =
      Field(
        "design",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("filename", filename), Argument("id", id))
      )

    /**
      * Find a design as of a version
      */
    def designAtVersion[A](id: String)(
        innerSelection: SelectionBuilder[DesignAtVersion, A]
    ): SelectionBuilder[DesignCollection, Option[A]] =
      Field(
        "designAtVersion",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * All designs for the design collection
      */
    def designs[A](
        after: Option[String] = None,
        atVersion: Option[String] = None,
        before: Option[String] = None,
        filenames: Option[List[String]] = None,
        first: Option[Int] = None,
        ids: Option[List[String]] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DesignConnection, A]
    ): SelectionBuilder[DesignCollection, A] =
      Field(
        "designs",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("atVersion", atVersion),
          Argument("before", before),
          Argument("filenames", filenames),
          Argument("first", first),
          Argument("ids", ids),
          Argument("last", last)
        )
      )

    /**
      * Issue associated with the design collection
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[DesignCollection, A] =
      Field("issue", Obj(innerSelection))

    /**
      * Project associated with the design collection
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[DesignCollection, A] =
      Field("project", Obj(innerSelection))

    /**
      * A specific version
      */
    def version[A](id: Option[String] = None, sha: Option[String] = None)(
        innerSelection: SelectionBuilder[DesignVersion, A]
    ): SelectionBuilder[DesignCollection, Option[A]] =
      Field(
        "version",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id), Argument("sha", sha))
      )

    /**
      * All versions related to all designs, ordered newest first
      */
    def versions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        earlierOrEqualToId: Option[String] = None,
        earlierOrEqualToSha: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DesignVersionConnection, A]
    ): SelectionBuilder[DesignCollection, A] =
      Field(
        "versions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("earlierOrEqualToId", earlierOrEqualToId),
          Argument("earlierOrEqualToSha", earlierOrEqualToSha),
          Argument("first", first),
          Argument("last", last)
        )
      )
  }

  type DesignConnection
  object DesignConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[DesignEdge, A]
    ): SelectionBuilder[DesignConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Design, A]
    ): SelectionBuilder[DesignConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[DesignConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type DesignEdge
  object DesignEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[DesignEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Design, A]
    ): SelectionBuilder[DesignEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type DesignManagement
  object DesignManagement {

    /**
      * Find a design as of a version
      */
    def designAtVersion[A](id: String)(
        innerSelection: SelectionBuilder[DesignAtVersion, A]
    ): SelectionBuilder[DesignManagement, Option[A]] =
      Field(
        "designAtVersion",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Find a version
      */
    def version[A](id: String)(
        innerSelection: SelectionBuilder[DesignVersion, A]
    ): SelectionBuilder[DesignManagement, Option[A]] =
      Field(
        "version",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )
  }

  type DesignManagementDeletePayload
  object DesignManagementDeletePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[DesignManagementDeletePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[DesignManagementDeletePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The new version in which the designs are deleted
      */
    def version[A](
        innerSelection: SelectionBuilder[DesignVersion, A]
    ): SelectionBuilder[DesignManagementDeletePayload, Option[A]] =
      Field("version", OptionOf(Obj(innerSelection)))
  }

  type DesignManagementUploadPayload
  object DesignManagementUploadPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[DesignManagementUploadPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * The designs that were uploaded by the mutation
      */
    def designs[A](
        innerSelection: SelectionBuilder[Design, A]
    ): SelectionBuilder[DesignManagementUploadPayload, List[A]] =
      Field("designs", ListOf(Obj(innerSelection)))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[DesignManagementUploadPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * Any designs that were skipped from the upload due to there being no change to their content since their last version
      */
    def skippedDesigns[A](
        innerSelection: SelectionBuilder[Design, A]
    ): SelectionBuilder[DesignManagementUploadPayload, List[A]] =
      Field("skippedDesigns", ListOf(Obj(innerSelection)))
  }

  type DesignVersion
  object DesignVersion {

    /**
      * A particular design as of this version, provided it is visible at this version
      */
    def designAtVersion[A](
        designId: Option[String] = None,
        filename: Option[String] = None,
        id: Option[String] = None
    )(
        innerSelection: SelectionBuilder[DesignAtVersion, A]
    ): SelectionBuilder[DesignVersion, A] =
      Field(
        "designAtVersion",
        Obj(innerSelection),
        arguments = List(
          Argument("designId", designId),
          Argument("filename", filename),
          Argument("id", id)
        )
      )

    /**
      * All designs that were changed in the version
      */
    def designs[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DesignConnection, A]
    ): SelectionBuilder[DesignVersion, A] =
      Field(
        "designs",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * All designs that are visible at this version, as of this version
      */
    def designsAtVersion[A](
        after: Option[String] = None,
        before: Option[String] = None,
        filenames: Option[List[String]] = None,
        first: Option[Int] = None,
        ids: Option[List[String]] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DesignAtVersionConnection, A]
    ): SelectionBuilder[DesignVersion, A] =
      Field(
        "designsAtVersion",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("filenames", filenames),
          Argument("first", first),
          Argument("ids", ids),
          Argument("last", last)
        )
      )

    /**
      * ID of the design version
      */
    def id: SelectionBuilder[DesignVersion, String] = Field("id", Scalar())

    /**
      * SHA of the design version
      */
    def sha: SelectionBuilder[DesignVersion, String] = Field("sha", Scalar())
  }

  type DesignVersionConnection
  object DesignVersionConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[DesignVersionEdge, A]
    ): SelectionBuilder[DesignVersionConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[DesignVersion, A]
    ): SelectionBuilder[DesignVersionConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[DesignVersionConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type DesignVersionEdge
  object DesignVersionEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[DesignVersionEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[DesignVersion, A]
    ): SelectionBuilder[DesignVersionEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type DestroyNotePayload
  object DestroyNotePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[DestroyNotePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[DestroyNotePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The note after mutation
      */
    def note[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[DestroyNotePayload, Option[A]] =
      Field("note", OptionOf(Obj(innerSelection)))
  }

  type DestroySnippetPayload
  object DestroySnippetPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[DestroySnippetPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[DestroySnippetPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The snippet after mutation
      */
    def snippet[A](
        innerSelection: SelectionBuilder[Snippet, A]
    ): SelectionBuilder[DestroySnippetPayload, Option[A]] =
      Field("snippet", OptionOf(Obj(innerSelection)))
  }

  type DetailedStatus
  object DetailedStatus {

    /**
      * Path of the details for the pipeline status
      */
    def detailsPath: SelectionBuilder[DetailedStatus, String] =
      Field("detailsPath", Scalar())

    /**
      * Favicon of the pipeline status
      */
    def favicon: SelectionBuilder[DetailedStatus, String] =
      Field("favicon", Scalar())

    /**
      * Group of the pipeline status
      */
    def group: SelectionBuilder[DetailedStatus, String] =
      Field("group", Scalar())

    /**
      * Indicates if the pipeline status has further details
      */
    def hasDetails: SelectionBuilder[DetailedStatus, Boolean] =
      Field("hasDetails", Scalar())

    /**
      * Icon of the pipeline status
      */
    def icon: SelectionBuilder[DetailedStatus, String] = Field("icon", Scalar())

    /**
      * Label of the pipeline status
      */
    def label: SelectionBuilder[DetailedStatus, String] =
      Field("label", Scalar())

    /**
      * Text of the pipeline status
      */
    def text: SelectionBuilder[DetailedStatus, String] = Field("text", Scalar())

    /**
      * Tooltip associated with the pipeline status
      */
    def tooltip: SelectionBuilder[DetailedStatus, String] =
      Field("tooltip", Scalar())
  }

  type DiffPosition
  object DiffPosition {

    /**
      * Information about the branch, HEAD, and base at the time of commenting
      */
    def diffRefs[A](
        innerSelection: SelectionBuilder[DiffRefs, A]
    ): SelectionBuilder[DiffPosition, A] =
      Field("diffRefs", Obj(innerSelection))

    /**
      * Path of the file that was changed
      */
    def filePath: SelectionBuilder[DiffPosition, String] =
      Field("filePath", Scalar())

    /**
      * Total height of the image
      */
    def height: SelectionBuilder[DiffPosition, Option[Int]] =
      Field("height", OptionOf(Scalar()))

    /**
      * Line on HEAD SHA that was changed
      */
    def newLine: SelectionBuilder[DiffPosition, Option[Int]] =
      Field("newLine", OptionOf(Scalar()))

    /**
      * Path of the file on the HEAD SHA
      */
    def newPath: SelectionBuilder[DiffPosition, Option[String]] =
      Field("newPath", OptionOf(Scalar()))

    /**
      * Line on start SHA that was changed
      */
    def oldLine: SelectionBuilder[DiffPosition, Option[Int]] =
      Field("oldLine", OptionOf(Scalar()))

    /**
      * Path of the file on the start SHA
      */
    def oldPath: SelectionBuilder[DiffPosition, Option[String]] =
      Field("oldPath", OptionOf(Scalar()))

    /**
      * Type of file the position refers to
      */
    def positionType: SelectionBuilder[DiffPosition, DiffPositionType] =
      Field("positionType", Scalar())

    /**
      * Total width of the image
      */
    def width: SelectionBuilder[DiffPosition, Option[Int]] =
      Field("width", OptionOf(Scalar()))

    /**
      * X position of the note
      */
    def x: SelectionBuilder[DiffPosition, Option[Int]] =
      Field("x", OptionOf(Scalar()))

    /**
      * Y position of the note
      */
    def y: SelectionBuilder[DiffPosition, Option[Int]] =
      Field("y", OptionOf(Scalar()))
  }

  type DiffRefs
  object DiffRefs {

    /**
      * Merge base of the branch the comment was made on
      */
    def baseSha: SelectionBuilder[DiffRefs, Option[String]] =
      Field("baseSha", OptionOf(Scalar()))

    /**
      * SHA of the HEAD at the time the comment was made
      */
    def headSha: SelectionBuilder[DiffRefs, String] = Field("headSha", Scalar())

    /**
      * SHA of the branch being compared against
      */
    def startSha: SelectionBuilder[DiffRefs, String] =
      Field("startSha", Scalar())
  }

  type Discussion
  object Discussion {

    /**
      * Timestamp of the discussion's creation
      */
    def createdAt: SelectionBuilder[Discussion, Time] =
      Field("createdAt", Scalar())

    /**
      * ID of this discussion
      */
    def id: SelectionBuilder[Discussion, String] = Field("id", Scalar())

    /**
      * All notes in the discussion
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[Discussion, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * ID used to reply to this discussion
      */
    def replyId: SelectionBuilder[Discussion, String] =
      Field("replyId", Scalar())
  }

  type DiscussionConnection
  object DiscussionConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[DiscussionEdge, A]
    ): SelectionBuilder[DiscussionConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Discussion, A]
    ): SelectionBuilder[DiscussionConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[DiscussionConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type DiscussionEdge
  object DiscussionEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[DiscussionEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Discussion, A]
    ): SelectionBuilder[DiscussionEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Environment
  object Environment {

    /**
      * ID of the environment
      */
    def id: SelectionBuilder[Environment, String] = Field("id", Scalar())

    /**
      * Human-readable name of the environment
      */
    def name: SelectionBuilder[Environment, String] = Field("name", Scalar())
  }

  type EnvironmentConnection
  object EnvironmentConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[EnvironmentEdge, A]
    ): SelectionBuilder[EnvironmentConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Environment, A]
    ): SelectionBuilder[EnvironmentConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[EnvironmentConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type EnvironmentEdge
  object EnvironmentEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[EnvironmentEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Environment, A]
    ): SelectionBuilder[EnvironmentEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Epic
  object Epic {

    /**
      * Author of the epic
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Epic, A] = Field("author", Obj(innerSelection))

    /**
      * Children (sub-epics) of the epic
      */
    def children[A](
        after: Option[String] = None,
        authorUsername: Option[String] = None,
        before: Option[String] = None,
        endDate: Option[Time] = None,
        first: Option[Int] = None,
        iid: Option[String] = None,
        iidStartsWith: Option[String] = None,
        iids: Option[List[String]] = None,
        labelName: Option[List[String]] = None,
        last: Option[Int] = None,
        search: Option[String] = None,
        sort: Option[EpicSort] = None,
        startDate: Option[Time] = None,
        state: Option[EpicState] = None
    )(
        innerSelection: SelectionBuilder[EpicConnection, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field(
        "children",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("authorUsername", authorUsername),
          Argument("before", before),
          Argument("endDate", endDate),
          Argument("first", first),
          Argument("iid", iid),
          Argument("iidStartsWith", iidStartsWith),
          Argument("iids", iids),
          Argument("labelName", labelName),
          Argument("last", last),
          Argument("search", search),
          Argument("sort", sort),
          Argument("startDate", startDate),
          Argument("state", state)
        )
      )

    /**
      * Timestamp of the epic's closure
      */
    def closedAt: SelectionBuilder[Epic, Option[Time]] =
      Field("closedAt", OptionOf(Scalar()))

    /**
      * Timestamp of the epic's creation
      */
    def createdAt: SelectionBuilder[Epic, Option[Time]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * Number of open and closed descendant epics and issues
      */
    def descendantCounts[A](
        innerSelection: SelectionBuilder[EpicDescendantCount, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field("descendantCounts", OptionOf(Obj(innerSelection)))

    /**
      * Total weight of open and closed issues in the epic and its descendants.
Available only when feature flag `unfiltered_epic_aggregates` is enabled.
      */
    def descendantWeightSum[A](
        innerSelection: SelectionBuilder[EpicDescendantWeights, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field("descendantWeightSum", OptionOf(Obj(innerSelection)))

    /**
      * Description of the epic
      */
    def description: SelectionBuilder[Epic, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * All discussions on this noteable
      */
    def discussions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DiscussionConnection, A]
    ): SelectionBuilder[Epic, A] =
      Field(
        "discussions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Number of downvotes the epic has received
      */
    def downvotes: SelectionBuilder[Epic, Int] = Field("downvotes", Scalar())

    /**
      * Due date of the epic
      */
    def dueDate: SelectionBuilder[Epic, Option[Time]] =
      Field("dueDate", OptionOf(Scalar()))

    /**
      * Fixed due date of the epic
      */
    def dueDateFixed: SelectionBuilder[Epic, Option[Time]] =
      Field("dueDateFixed", OptionOf(Scalar()))

    /**
      * Inherited due date of the epic from milestones
      */
    def dueDateFromMilestones: SelectionBuilder[Epic, Option[Time]] =
      Field("dueDateFromMilestones", OptionOf(Scalar()))

    /**
      * Indicates if the due date has been manually set
      */
    def dueDateIsFixed: SelectionBuilder[Epic, Option[Boolean]] =
      Field("dueDateIsFixed", OptionOf(Scalar()))

    /**
      * Group to which the epic belongs
      */
    def group[A](
        innerSelection: SelectionBuilder[Group, A]
    ): SelectionBuilder[Epic, A] = Field("group", Obj(innerSelection))

    /**
      * Indicates if the epic has children
      */
    def hasChildren: SelectionBuilder[Epic, Boolean] =
      Field("hasChildren", Scalar())

    /**
      * Indicates if the epic has direct issues
      */
    def hasIssues: SelectionBuilder[Epic, Boolean] =
      Field("hasIssues", Scalar())

    /**
      * Current health status of the epic
      */
    def healthStatus[A](
        innerSelection: SelectionBuilder[EpicHealthStatus, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field("healthStatus", OptionOf(Obj(innerSelection)))

    /**
      * ID of the epic
      */
    def id: SelectionBuilder[Epic, String] = Field("id", Scalar())

    /**
      * Internal ID of the epic
      */
    def iid: SelectionBuilder[Epic, String] = Field("iid", Scalar())

    /**
      * A list of issues associated with the epic
      */
    def issues[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[EpicIssueConnection, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field(
        "issues",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Labels assigned to the epic
      */
    def labels[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[LabelConnection, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field(
        "labels",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * All notes on this noteable
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[Epic, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Parent epic of the epic
      */
    def parent[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field("parent", OptionOf(Obj(innerSelection)))

    /**
      * List of participants for the epic
      */
    def participants[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[Epic, Option[A]] =
      Field(
        "participants",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Internal reference of the epic. Returned in shortened format by default
      */
    def reference(
        full: Option[Boolean] = None
    ): SelectionBuilder[Epic, String] =
      Field("reference", Scalar(), arguments = List(Argument("full", full)))

    /**
      * URI path of the epic-issue relationship
      */
    def relationPath: SelectionBuilder[Epic, Option[String]] =
      Field("relationPath", OptionOf(Scalar()))

    /**
      * The relative position of the epic in the epic tree
      */
    def relativePosition: SelectionBuilder[Epic, Option[Int]] =
      Field("relativePosition", OptionOf(Scalar()))

    /**
      * Start date of the epic
      */
    def startDate: SelectionBuilder[Epic, Option[Time]] =
      Field("startDate", OptionOf(Scalar()))

    /**
      * Fixed start date of the epic
      */
    def startDateFixed: SelectionBuilder[Epic, Option[Time]] =
      Field("startDateFixed", OptionOf(Scalar()))

    /**
      * Inherited start date of the epic from milestones
      */
    def startDateFromMilestones: SelectionBuilder[Epic, Option[Time]] =
      Field("startDateFromMilestones", OptionOf(Scalar()))

    /**
      * Indicates if the start date has been manually set
      */
    def startDateIsFixed: SelectionBuilder[Epic, Option[Boolean]] =
      Field("startDateIsFixed", OptionOf(Scalar()))

    /**
      * State of the epic
      */
    def state: SelectionBuilder[Epic, EpicState] = Field("state", Scalar())

    /**
      * Indicates the currently logged in user is subscribed to the epic
      */
    def subscribed: SelectionBuilder[Epic, Boolean] =
      Field("subscribed", Scalar())

    /**
      * Title of the epic
      */
    def title: SelectionBuilder[Epic, Option[String]] =
      Field("title", OptionOf(Scalar()))

    /**
      * Timestamp of the epic's last activity
      */
    def updatedAt: SelectionBuilder[Epic, Option[Time]] =
      Field("updatedAt", OptionOf(Scalar()))

    /**
      * Number of upvotes the epic has received
      */
    def upvotes: SelectionBuilder[Epic, Int] = Field("upvotes", Scalar())

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[EpicPermissions, A]
    ): SelectionBuilder[Epic, A] = Field("userPermissions", Obj(innerSelection))

    /**
      * Web path of the epic
      */
    def webPath: SelectionBuilder[Epic, String] = Field("webPath", Scalar())

    /**
      * Web URL of the epic
      */
    def webUrl: SelectionBuilder[Epic, String] = Field("webUrl", Scalar())
  }

  type EpicAddIssuePayload
  object EpicAddIssuePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[EpicAddIssuePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * The epic after mutation
      */
    def epic[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[EpicAddIssuePayload, Option[A]] =
      Field("epic", OptionOf(Obj(innerSelection)))

    /**
      * The epic-issue relation
      */
    def epicIssue[A](
        innerSelection: SelectionBuilder[EpicIssue, A]
    ): SelectionBuilder[EpicAddIssuePayload, Option[A]] =
      Field("epicIssue", OptionOf(Obj(innerSelection)))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[EpicAddIssuePayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type EpicConnection
  object EpicConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[EpicEdge, A]
    ): SelectionBuilder[EpicConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[EpicConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[EpicConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type EpicDescendantCount
  object EpicDescendantCount {

    /**
      * Number of closed sub-epics
      */
    def closedEpics: SelectionBuilder[EpicDescendantCount, Option[Int]] =
      Field("closedEpics", OptionOf(Scalar()))

    /**
      * Number of closed epic issues
      */
    def closedIssues: SelectionBuilder[EpicDescendantCount, Option[Int]] =
      Field("closedIssues", OptionOf(Scalar()))

    /**
      * Number of opened sub-epics
      */
    def openedEpics: SelectionBuilder[EpicDescendantCount, Option[Int]] =
      Field("openedEpics", OptionOf(Scalar()))

    /**
      * Number of opened epic issues
      */
    def openedIssues: SelectionBuilder[EpicDescendantCount, Option[Int]] =
      Field("openedIssues", OptionOf(Scalar()))
  }

  type EpicDescendantWeights
  object EpicDescendantWeights {

    /**
      * Total weight of completed (closed) issues in this epic, including epic descendants
      */
    def closedIssues: SelectionBuilder[EpicDescendantWeights, Option[Int]] =
      Field("closedIssues", OptionOf(Scalar()))

    /**
      * Total weight of opened issues in this epic, including epic descendants
      */
    def openedIssues: SelectionBuilder[EpicDescendantWeights, Option[Int]] =
      Field("openedIssues", OptionOf(Scalar()))
  }

  type EpicEdge
  object EpicEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[EpicEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[EpicEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type EpicHealthStatus
  object EpicHealthStatus {

    /**
      * Number of issues at risk
      */
    def issuesAtRisk: SelectionBuilder[EpicHealthStatus, Option[Int]] =
      Field("issuesAtRisk", OptionOf(Scalar()))

    /**
      * Number of issues that need attention
      */
    def issuesNeedingAttention
        : SelectionBuilder[EpicHealthStatus, Option[Int]] =
      Field("issuesNeedingAttention", OptionOf(Scalar()))

    /**
      * Number of issues on track
      */
    def issuesOnTrack: SelectionBuilder[EpicHealthStatus, Option[Int]] =
      Field("issuesOnTrack", OptionOf(Scalar()))
  }

  type EpicIssue
  object EpicIssue {

    /**
      * Assignees of the issue
      */
    def assignees[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field(
        "assignees",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * User that created the issue
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[EpicIssue, A] = Field("author", Obj(innerSelection))

    /**
      * Timestamp of when the issue was closed
      */
    def closedAt: SelectionBuilder[EpicIssue, Option[Time]] =
      Field("closedAt", OptionOf(Scalar()))

    /**
      * Indicates the issue is confidential
      */
    def confidential: SelectionBuilder[EpicIssue, Boolean] =
      Field("confidential", Scalar())

    /**
      * Timestamp of when the issue was created
      */
    def createdAt: SelectionBuilder[EpicIssue, Time] =
      Field("createdAt", Scalar())

    /**
      * Description of the issue
      */
    def description: SelectionBuilder[EpicIssue, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[EpicIssue, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Collection of design images associated with this issue
      */
    def designCollection[A](
        innerSelection: SelectionBuilder[DesignCollection, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field("designCollection", OptionOf(Obj(innerSelection)))

    /**
      * Deprecated. Use `designCollection`
      */
    @deprecated("Use designCollection", "")
    def designs[A](
        innerSelection: SelectionBuilder[DesignCollection, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field("designs", OptionOf(Obj(innerSelection)))

    /**
      * Indicates discussion is locked on the issue
      */
    def discussionLocked: SelectionBuilder[EpicIssue, Boolean] =
      Field("discussionLocked", Scalar())

    /**
      * All discussions on this noteable
      */
    def discussions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DiscussionConnection, A]
    ): SelectionBuilder[EpicIssue, A] =
      Field(
        "discussions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Number of downvotes the issue has received
      */
    def downvotes: SelectionBuilder[EpicIssue, Int] =
      Field("downvotes", Scalar())

    /**
      * Due date of the issue
      */
    def dueDate: SelectionBuilder[EpicIssue, Option[Time]] =
      Field("dueDate", OptionOf(Scalar()))

    /**
      * Epic to which this issue belongs
      */
    def epic[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field("epic", OptionOf(Obj(innerSelection)))

    /**
      * ID of the epic-issue relation
      */
    def epicIssueId: SelectionBuilder[EpicIssue, String] =
      Field("epicIssueId", Scalar())

    /**
      * Current health status. Available only when feature flag `save_issuable_health_status` is enabled.
      */
    def healthStatus: SelectionBuilder[EpicIssue, Option[HealthStatus]] =
      Field("healthStatus", OptionOf(Scalar()))

    /**
      * Global ID of the epic-issue relation
      */
    def id: SelectionBuilder[EpicIssue, Option[String]] =
      Field("id", OptionOf(Scalar()))

    /**
      * Internal ID of the issue
      */
    def iid: SelectionBuilder[EpicIssue, String] = Field("iid", Scalar())

    /**
      * Labels of the issue
      */
    def labels[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[LabelConnection, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field(
        "labels",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Milestone of the issue
      */
    def milestone[A](
        innerSelection: SelectionBuilder[Milestone, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field("milestone", OptionOf(Obj(innerSelection)))

    /**
      * All notes on this noteable
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[EpicIssue, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * List of participants in the issue
      */
    def participants[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[EpicIssue, Option[A]] =
      Field(
        "participants",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Internal reference of the issue. Returned in shortened format by default
      */
    def reference(
        full: Option[Boolean] = None
    ): SelectionBuilder[EpicIssue, String] =
      Field("reference", Scalar(), arguments = List(Argument("full", full)))

    /**
      * URI path of the epic-issue relation
      */
    def relationPath: SelectionBuilder[EpicIssue, Option[String]] =
      Field("relationPath", OptionOf(Scalar()))

    /**
      * Relative position of the issue (used for positioning in epic tree and issue boards)
      */
    def relativePosition: SelectionBuilder[EpicIssue, Option[Int]] =
      Field("relativePosition", OptionOf(Scalar()))

    /**
      * State of the issue
      */
    def state: SelectionBuilder[EpicIssue, IssueState] =
      Field("state", Scalar())

    /**
      * Indicates the currently logged in user is subscribed to the issue
      */
    def subscribed: SelectionBuilder[EpicIssue, Boolean] =
      Field("subscribed", Scalar())

    /**
      * Task completion status of the issue
      */
    def taskCompletionStatus[A](
        innerSelection: SelectionBuilder[TaskCompletionStatus, A]
    ): SelectionBuilder[EpicIssue, A] =
      Field("taskCompletionStatus", Obj(innerSelection))

    /**
      * Time estimate of the issue
      */
    def timeEstimate: SelectionBuilder[EpicIssue, Int] =
      Field("timeEstimate", Scalar())

    /**
      * Title of the issue
      */
    def title: SelectionBuilder[EpicIssue, String] = Field("title", Scalar())

    /**
      * The GitLab Flavored Markdown rendering of `title`
      */
    def titleHtml: SelectionBuilder[EpicIssue, Option[String]] =
      Field("titleHtml", OptionOf(Scalar()))

    /**
      * Total time reported as spent on the issue
      */
    def totalTimeSpent: SelectionBuilder[EpicIssue, Int] =
      Field("totalTimeSpent", Scalar())

    /**
      * Timestamp of when the issue was last updated
      */
    def updatedAt: SelectionBuilder[EpicIssue, Time] =
      Field("updatedAt", Scalar())

    /**
      * Number of upvotes the issue has received
      */
    def upvotes: SelectionBuilder[EpicIssue, Int] = Field("upvotes", Scalar())

    /**
      * Number of user notes of the issue
      */
    def userNotesCount: SelectionBuilder[EpicIssue, Int] =
      Field("userNotesCount", Scalar())

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[IssuePermissions, A]
    ): SelectionBuilder[EpicIssue, A] =
      Field("userPermissions", Obj(innerSelection))

    /**
      * Web path of the issue
      */
    def webPath: SelectionBuilder[EpicIssue, String] =
      Field("webPath", Scalar())

    /**
      * Web URL of the issue
      */
    def webUrl: SelectionBuilder[EpicIssue, String] = Field("webUrl", Scalar())

    /**
      * Weight of the issue
      */
    def weight: SelectionBuilder[EpicIssue, Option[Int]] =
      Field("weight", OptionOf(Scalar()))
  }

  type EpicIssueConnection
  object EpicIssueConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[EpicIssueEdge, A]
    ): SelectionBuilder[EpicIssueConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[EpicIssue, A]
    ): SelectionBuilder[EpicIssueConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[EpicIssueConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type EpicIssueEdge
  object EpicIssueEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[EpicIssueEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[EpicIssue, A]
    ): SelectionBuilder[EpicIssueEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type EpicPermissions
  object EpicPermissions {

    /**
      * Indicates the user can perform `admin_epic` on this resource
      */
    def adminEpic: SelectionBuilder[EpicPermissions, Boolean] =
      Field("adminEpic", Scalar())

    /**
      * Indicates the user can perform `award_emoji` on this resource
      */
    def awardEmoji: SelectionBuilder[EpicPermissions, Boolean] =
      Field("awardEmoji", Scalar())

    /**
      * Indicates the user can perform `create_epic` on this resource
      */
    def createEpic: SelectionBuilder[EpicPermissions, Boolean] =
      Field("createEpic", Scalar())

    /**
      * Indicates the user can perform `create_note` on this resource
      */
    def createNote: SelectionBuilder[EpicPermissions, Boolean] =
      Field("createNote", Scalar())

    /**
      * Indicates the user can perform `destroy_epic` on this resource
      */
    def destroyEpic: SelectionBuilder[EpicPermissions, Boolean] =
      Field("destroyEpic", Scalar())

    /**
      * Indicates the user can perform `read_epic` on this resource
      */
    def readEpic: SelectionBuilder[EpicPermissions, Boolean] =
      Field("readEpic", Scalar())

    /**
      * Indicates the user can perform `read_epic_iid` on this resource
      */
    def readEpicIid: SelectionBuilder[EpicPermissions, Boolean] =
      Field("readEpicIid", Scalar())

    /**
      * Indicates the user can perform `update_epic` on this resource
      */
    def updateEpic: SelectionBuilder[EpicPermissions, Boolean] =
      Field("updateEpic", Scalar())
  }

  type EpicSetSubscriptionPayload
  object EpicSetSubscriptionPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[EpicSetSubscriptionPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * The epic after mutation
      */
    def epic[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[EpicSetSubscriptionPayload, Option[A]] =
      Field("epic", OptionOf(Obj(innerSelection)))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[EpicSetSubscriptionPayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type EpicTreeReorderPayload
  object EpicTreeReorderPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[EpicTreeReorderPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[EpicTreeReorderPayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type GrafanaIntegration
  object GrafanaIntegration {

    /**
      * Timestamp of the issue's creation
      */
    def createdAt: SelectionBuilder[GrafanaIntegration, Time] =
      Field("createdAt", Scalar())

    /**
      * Indicates whether Grafana integration is enabled
      */
    def enabled: SelectionBuilder[GrafanaIntegration, Boolean] =
      Field("enabled", Scalar())

    /**
      * Url for the Grafana host for the Grafana integration
      */
    def grafanaUrl: SelectionBuilder[GrafanaIntegration, String] =
      Field("grafanaUrl", Scalar())

    /**
      * Internal ID of the Grafana integration
      */
    def id: SelectionBuilder[GrafanaIntegration, String] = Field("id", Scalar())

    /**
      * API token for the Grafana integration. Field is permanently masked.
      */
    @deprecated("Plain text token has been masked for security reasons", "")
    def token: SelectionBuilder[GrafanaIntegration, String] =
      Field("token", Scalar())

    /**
      * Timestamp of the issue's last activity
      */
    def updatedAt: SelectionBuilder[GrafanaIntegration, Time] =
      Field("updatedAt", Scalar())
  }

  type Group
  object Group {

    /**
      * Indicates whether Auto DevOps is enabled for all projects within this group
      */
    def autoDevopsEnabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("autoDevopsEnabled", OptionOf(Scalar()))

    /**
      * Avatar URL of the group
      */
    def avatarUrl: SelectionBuilder[Group, Option[String]] =
      Field("avatarUrl", OptionOf(Scalar()))

    /**
      * A single board of the group
      */
    def board[A](id: Option[String] = None)(
        innerSelection: SelectionBuilder[Board, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field(
        "board",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Boards of the group
      */
    def boards[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        id: Option[String] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[BoardConnection, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field(
        "boards",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("id", id),
          Argument("last", last)
        )
      )

    /**
      * Description of the namespace
      */
    def description: SelectionBuilder[Group, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[Group, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Indicates if a group has email notifications disabled
      */
    def emailsDisabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("emailsDisabled", OptionOf(Scalar()))

    /**
      * Find a single epic
      */
    def epic[A](
        authorUsername: Option[String] = None,
        endDate: Option[Time] = None,
        iid: Option[String] = None,
        iidStartsWith: Option[String] = None,
        iids: Option[List[String]] = None,
        labelName: Option[List[String]] = None,
        search: Option[String] = None,
        sort: Option[EpicSort] = None,
        startDate: Option[Time] = None,
        state: Option[EpicState] = None
    )(
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field(
        "epic",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("authorUsername", authorUsername),
          Argument("endDate", endDate),
          Argument("iid", iid),
          Argument("iidStartsWith", iidStartsWith),
          Argument("iids", iids),
          Argument("labelName", labelName),
          Argument("search", search),
          Argument("sort", sort),
          Argument("startDate", startDate),
          Argument("state", state)
        )
      )

    /**
      * Find epics
      */
    def epics[A](
        after: Option[String] = None,
        authorUsername: Option[String] = None,
        before: Option[String] = None,
        endDate: Option[Time] = None,
        first: Option[Int] = None,
        iid: Option[String] = None,
        iidStartsWith: Option[String] = None,
        iids: Option[List[String]] = None,
        labelName: Option[List[String]] = None,
        last: Option[Int] = None,
        search: Option[String] = None,
        sort: Option[EpicSort] = None,
        startDate: Option[Time] = None,
        state: Option[EpicState] = None
    )(
        innerSelection: SelectionBuilder[EpicConnection, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field(
        "epics",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("authorUsername", authorUsername),
          Argument("before", before),
          Argument("endDate", endDate),
          Argument("first", first),
          Argument("iid", iid),
          Argument("iidStartsWith", iidStartsWith),
          Argument("iids", iids),
          Argument("labelName", labelName),
          Argument("last", last),
          Argument("search", search),
          Argument("sort", sort),
          Argument("startDate", startDate),
          Argument("state", state)
        )
      )

    /**
      * Indicates if Epics are enabled for namespace
      */
    def epicsEnabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("epicsEnabled", OptionOf(Scalar()))

    /**
      * Full name of the namespace
      */
    def fullName: SelectionBuilder[Group, String] = Field("fullName", Scalar())

    /**
      * Full path of the namespace
      */
    def fullPath: SelectionBuilder[Group, String] = Field("fullPath", Scalar())

    /**
      * Indicates if Group timelogs are enabled for namespace
      */
    def groupTimelogsEnabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("groupTimelogsEnabled", OptionOf(Scalar()))

    /**
      * ID of the namespace
      */
    def id: SelectionBuilder[Group, String] = Field("id", Scalar())

    /**
      * Indicates if Large File Storage (LFS) is enabled for namespace
      */
    def lfsEnabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("lfsEnabled", OptionOf(Scalar()))

    /**
      * Indicates if a group is disabled from getting mentioned
      */
    def mentionsDisabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("mentionsDisabled", OptionOf(Scalar()))

    /**
      * Find milestones
      */
    def milestones[A](
        after: Option[String] = None,
        before: Option[String] = None,
        endDate: Option[Time] = None,
        first: Option[Int] = None,
        last: Option[Int] = None,
        startDate: Option[Time] = None,
        state: Option[MilestoneStateEnum] = None
    )(
        innerSelection: SelectionBuilder[MilestoneConnection, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field(
        "milestones",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("endDate", endDate),
          Argument("first", first),
          Argument("last", last),
          Argument("startDate", startDate),
          Argument("state", state)
        )
      )

    /**
      * Name of the namespace
      */
    def name: SelectionBuilder[Group, String] = Field("name", Scalar())

    /**
      * Parent group
      */
    def parent[A](
        innerSelection: SelectionBuilder[Group, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field("parent", OptionOf(Obj(innerSelection)))

    /**
      * Path of the namespace
      */
    def path: SelectionBuilder[Group, String] = Field("path", Scalar())

    /**
      * The permission level required to create projects in the group
      */
    def projectCreationLevel: SelectionBuilder[Group, Option[String]] =
      Field("projectCreationLevel", OptionOf(Scalar()))

    /**
      * Projects within this namespace
      */
    def projects[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        includeSubgroups: Option[Boolean] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ProjectConnection, A]
    ): SelectionBuilder[Group, A] =
      Field(
        "projects",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("includeSubgroups", includeSubgroups),
          Argument("last", last)
        )
      )

    /**
      * Indicates if users can request access to namespace
      */
    def requestAccessEnabled: SelectionBuilder[Group, Option[Boolean]] =
      Field("requestAccessEnabled", OptionOf(Scalar()))

    /**
      * Indicates if all users in this group are required to set up two-factor authentication
      */
    def requireTwoFactorAuthentication
        : SelectionBuilder[Group, Option[Boolean]] =
      Field("requireTwoFactorAuthentication", OptionOf(Scalar()))

    /**
      * Aggregated storage statistics of the namespace. Only available for root namespaces
      */
    def rootStorageStatistics[A](
        innerSelection: SelectionBuilder[RootStorageStatistics, A]
    ): SelectionBuilder[Group, Option[A]] =
      Field("rootStorageStatistics", OptionOf(Obj(innerSelection)))

    /**
      * Indicates if sharing a project with another group within this group is prevented
      */
    def shareWithGroupLock: SelectionBuilder[Group, Option[Boolean]] =
      Field("shareWithGroupLock", OptionOf(Scalar()))

    /**
      * The permission level required to create subgroups within the group
      */
    def subgroupCreationLevel: SelectionBuilder[Group, Option[String]] =
      Field("subgroupCreationLevel", OptionOf(Scalar()))

    /**
      * Time logged in issues by group members
      */
    def timelogs[A](
        after: Option[String] = None,
        before: Option[String] = None,
        endDate: Time,
        first: Option[Int] = None,
        last: Option[Int] = None,
        startDate: Time
    )(
        innerSelection: SelectionBuilder[TimelogConnection, A]
    ): SelectionBuilder[Group, A] =
      Field(
        "timelogs",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("endDate", endDate),
          Argument("first", first),
          Argument("last", last),
          Argument("startDate", startDate)
        )
      )

    /**
      * Time before two-factor authentication is enforced
      */
    def twoFactorGracePeriod: SelectionBuilder[Group, Option[Int]] =
      Field("twoFactorGracePeriod", OptionOf(Scalar()))

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[GroupPermissions, A]
    ): SelectionBuilder[Group, A] =
      Field("userPermissions", Obj(innerSelection))

    /**
      * Visibility of the namespace
      */
    def visibility: SelectionBuilder[Group, Option[String]] =
      Field("visibility", OptionOf(Scalar()))

    /**
      * Web URL of the group
      */
    def webUrl: SelectionBuilder[Group, String] = Field("webUrl", Scalar())
  }

  type GroupPermissions
  object GroupPermissions {

    /**
      * Indicates the user can perform `read_group` on this resource
      */
    def readGroup: SelectionBuilder[GroupPermissions, Boolean] =
      Field("readGroup", Scalar())
  }

  type Issue
  object Issue {

    /**
      * Assignees of the issue
      */
    def assignees[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field(
        "assignees",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * User that created the issue
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Issue, A] = Field("author", Obj(innerSelection))

    /**
      * Timestamp of when the issue was closed
      */
    def closedAt: SelectionBuilder[Issue, Option[Time]] =
      Field("closedAt", OptionOf(Scalar()))

    /**
      * Indicates the issue is confidential
      */
    def confidential: SelectionBuilder[Issue, Boolean] =
      Field("confidential", Scalar())

    /**
      * Timestamp of when the issue was created
      */
    def createdAt: SelectionBuilder[Issue, Time] = Field("createdAt", Scalar())

    /**
      * Description of the issue
      */
    def description: SelectionBuilder[Issue, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[Issue, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Collection of design images associated with this issue
      */
    def designCollection[A](
        innerSelection: SelectionBuilder[DesignCollection, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field("designCollection", OptionOf(Obj(innerSelection)))

    /**
      * Deprecated. Use `designCollection`
      */
    @deprecated("Use designCollection", "")
    def designs[A](
        innerSelection: SelectionBuilder[DesignCollection, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field("designs", OptionOf(Obj(innerSelection)))

    /**
      * Indicates discussion is locked on the issue
      */
    def discussionLocked: SelectionBuilder[Issue, Boolean] =
      Field("discussionLocked", Scalar())

    /**
      * All discussions on this noteable
      */
    def discussions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DiscussionConnection, A]
    ): SelectionBuilder[Issue, A] =
      Field(
        "discussions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Number of downvotes the issue has received
      */
    def downvotes: SelectionBuilder[Issue, Int] = Field("downvotes", Scalar())

    /**
      * Due date of the issue
      */
    def dueDate: SelectionBuilder[Issue, Option[Time]] =
      Field("dueDate", OptionOf(Scalar()))

    /**
      * Epic to which this issue belongs
      */
    def epic[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field("epic", OptionOf(Obj(innerSelection)))

    /**
      * Current health status. Available only when feature flag `save_issuable_health_status` is enabled.
      */
    def healthStatus: SelectionBuilder[Issue, Option[HealthStatus]] =
      Field("healthStatus", OptionOf(Scalar()))

    /**
      * Internal ID of the issue
      */
    def iid: SelectionBuilder[Issue, String] = Field("iid", Scalar())

    /**
      * Labels of the issue
      */
    def labels[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[LabelConnection, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field(
        "labels",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Milestone of the issue
      */
    def milestone[A](
        innerSelection: SelectionBuilder[Milestone, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field("milestone", OptionOf(Obj(innerSelection)))

    /**
      * All notes on this noteable
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[Issue, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * List of participants in the issue
      */
    def participants[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[Issue, Option[A]] =
      Field(
        "participants",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Internal reference of the issue. Returned in shortened format by default
      */
    def reference(
        full: Option[Boolean] = None
    ): SelectionBuilder[Issue, String] =
      Field("reference", Scalar(), arguments = List(Argument("full", full)))

    /**
      * Relative position of the issue (used for positioning in epic tree and issue boards)
      */
    def relativePosition: SelectionBuilder[Issue, Option[Int]] =
      Field("relativePosition", OptionOf(Scalar()))

    /**
      * State of the issue
      */
    def state: SelectionBuilder[Issue, IssueState] = Field("state", Scalar())

    /**
      * Indicates the currently logged in user is subscribed to the issue
      */
    def subscribed: SelectionBuilder[Issue, Boolean] =
      Field("subscribed", Scalar())

    /**
      * Task completion status of the issue
      */
    def taskCompletionStatus[A](
        innerSelection: SelectionBuilder[TaskCompletionStatus, A]
    ): SelectionBuilder[Issue, A] =
      Field("taskCompletionStatus", Obj(innerSelection))

    /**
      * Time estimate of the issue
      */
    def timeEstimate: SelectionBuilder[Issue, Int] =
      Field("timeEstimate", Scalar())

    /**
      * Title of the issue
      */
    def title: SelectionBuilder[Issue, String] = Field("title", Scalar())

    /**
      * The GitLab Flavored Markdown rendering of `title`
      */
    def titleHtml: SelectionBuilder[Issue, Option[String]] =
      Field("titleHtml", OptionOf(Scalar()))

    /**
      * Total time reported as spent on the issue
      */
    def totalTimeSpent: SelectionBuilder[Issue, Int] =
      Field("totalTimeSpent", Scalar())

    /**
      * Timestamp of when the issue was last updated
      */
    def updatedAt: SelectionBuilder[Issue, Time] = Field("updatedAt", Scalar())

    /**
      * Number of upvotes the issue has received
      */
    def upvotes: SelectionBuilder[Issue, Int] = Field("upvotes", Scalar())

    /**
      * Number of user notes of the issue
      */
    def userNotesCount: SelectionBuilder[Issue, Int] =
      Field("userNotesCount", Scalar())

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[IssuePermissions, A]
    ): SelectionBuilder[Issue, A] =
      Field("userPermissions", Obj(innerSelection))

    /**
      * Web path of the issue
      */
    def webPath: SelectionBuilder[Issue, String] = Field("webPath", Scalar())

    /**
      * Web URL of the issue
      */
    def webUrl: SelectionBuilder[Issue, String] = Field("webUrl", Scalar())

    /**
      * Weight of the issue
      */
    def weight: SelectionBuilder[Issue, Option[Int]] =
      Field("weight", OptionOf(Scalar()))
  }

  type IssueConnection
  object IssueConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[IssueEdge, A]
    ): SelectionBuilder[IssueConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssueConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[IssueConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type IssueEdge
  object IssueEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[IssueEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssueEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type IssuePermissions
  object IssuePermissions {

    /**
      * Indicates the user can perform `admin_issue` on this resource
      */
    def adminIssue: SelectionBuilder[IssuePermissions, Boolean] =
      Field("adminIssue", Scalar())

    /**
      * Indicates the user can perform `create_design` on this resource
      */
    def createDesign: SelectionBuilder[IssuePermissions, Boolean] =
      Field("createDesign", Scalar())

    /**
      * Indicates the user can perform `create_note` on this resource
      */
    def createNote: SelectionBuilder[IssuePermissions, Boolean] =
      Field("createNote", Scalar())

    /**
      * Indicates the user can perform `destroy_design` on this resource
      */
    def destroyDesign: SelectionBuilder[IssuePermissions, Boolean] =
      Field("destroyDesign", Scalar())

    /**
      * Indicates the user can perform `read_design` on this resource
      */
    def readDesign: SelectionBuilder[IssuePermissions, Boolean] =
      Field("readDesign", Scalar())

    /**
      * Indicates the user can perform `read_issue` on this resource
      */
    def readIssue: SelectionBuilder[IssuePermissions, Boolean] =
      Field("readIssue", Scalar())

    /**
      * Indicates the user can perform `reopen_issue` on this resource
      */
    def reopenIssue: SelectionBuilder[IssuePermissions, Boolean] =
      Field("reopenIssue", Scalar())

    /**
      * Indicates the user can perform `update_issue` on this resource
      */
    def updateIssue: SelectionBuilder[IssuePermissions, Boolean] =
      Field("updateIssue", Scalar())
  }

  type IssueSetConfidentialPayload
  object IssueSetConfidentialPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[IssueSetConfidentialPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[IssueSetConfidentialPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The issue after mutation
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssueSetConfidentialPayload, Option[A]] =
      Field("issue", OptionOf(Obj(innerSelection)))
  }

  type IssueSetDueDatePayload
  object IssueSetDueDatePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[IssueSetDueDatePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[IssueSetDueDatePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The issue after mutation
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssueSetDueDatePayload, Option[A]] =
      Field("issue", OptionOf(Obj(innerSelection)))
  }

  type IssueSetWeightPayload
  object IssueSetWeightPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[IssueSetWeightPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[IssueSetWeightPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The issue after mutation
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[IssueSetWeightPayload, Option[A]] =
      Field("issue", OptionOf(Obj(innerSelection)))
  }

  type Label
  object Label {

    /**
      * Background color of the label
      */
    def color: SelectionBuilder[Label, String] = Field("color", Scalar())

    /**
      * Description of the label (Markdown rendered as HTML for caching)
      */
    def description: SelectionBuilder[Label, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[Label, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Label ID
      */
    def id: SelectionBuilder[Label, String] = Field("id", Scalar())

    /**
      * Text color of the label
      */
    def textColor: SelectionBuilder[Label, String] =
      Field("textColor", Scalar())

    /**
      * Content of the label
      */
    def title: SelectionBuilder[Label, String] = Field("title", Scalar())
  }

  type LabelConnection
  object LabelConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[LabelEdge, A]
    ): SelectionBuilder[LabelConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Label, A]
    ): SelectionBuilder[LabelConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[LabelConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type LabelEdge
  object LabelEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[LabelEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Label, A]
    ): SelectionBuilder[LabelEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type MarkAsSpamSnippetPayload
  object MarkAsSpamSnippetPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MarkAsSpamSnippetPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[MarkAsSpamSnippetPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The snippet after mutation
      */
    def snippet[A](
        innerSelection: SelectionBuilder[Snippet, A]
    ): SelectionBuilder[MarkAsSpamSnippetPayload, Option[A]] =
      Field("snippet", OptionOf(Obj(innerSelection)))
  }

  type MergeRequest
  object MergeRequest {

    /**
      * Indicates if members of the target project can push to the fork
      */
    def allowCollaboration: SelectionBuilder[MergeRequest, Option[Boolean]] =
      Field("allowCollaboration", OptionOf(Scalar()))

    /**
      * Assignees of the merge request
      */
    def assignees[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field(
        "assignees",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Timestamp of when the merge request was created
      */
    def createdAt: SelectionBuilder[MergeRequest, Time] =
      Field("createdAt", Scalar())

    /**
      * Default merge commit message of the merge request
      */
    def defaultMergeCommitMessage
        : SelectionBuilder[MergeRequest, Option[String]] =
      Field("defaultMergeCommitMessage", OptionOf(Scalar()))

    /**
      * Description of the merge request (Markdown rendered as HTML for caching)
      */
    def description: SelectionBuilder[MergeRequest, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[MergeRequest, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Diff head SHA of the merge request
      */
    def diffHeadSha: SelectionBuilder[MergeRequest, Option[String]] =
      Field("diffHeadSha", OptionOf(Scalar()))

    /**
      * References of the base SHA, the head SHA, and the start SHA for this merge request
      */
    def diffRefs[A](
        innerSelection: SelectionBuilder[DiffRefs, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field("diffRefs", OptionOf(Obj(innerSelection)))

    /**
      * Indicates if comments on the merge request are locked to members only
      */
    def discussionLocked: SelectionBuilder[MergeRequest, Boolean] =
      Field("discussionLocked", Scalar())

    /**
      * All discussions on this noteable
      */
    def discussions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DiscussionConnection, A]
    ): SelectionBuilder[MergeRequest, A] =
      Field(
        "discussions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Number of downvotes for the merge request
      */
    def downvotes: SelectionBuilder[MergeRequest, Int] =
      Field("downvotes", Scalar())

    /**
      * Indicates if the project settings will lead to source branch deletion after merge
      */
    def forceRemoveSourceBranch
        : SelectionBuilder[MergeRequest, Option[Boolean]] =
      Field("forceRemoveSourceBranch", OptionOf(Scalar()))

    /**
      * The pipeline running on the branch HEAD of the merge request
      */
    def headPipeline[A](
        innerSelection: SelectionBuilder[Pipeline, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field("headPipeline", OptionOf(Obj(innerSelection)))

    /**
      * ID of the merge request
      */
    def id: SelectionBuilder[MergeRequest, String] = Field("id", Scalar())

    /**
      * Internal ID of the merge request
      */
    def iid: SelectionBuilder[MergeRequest, String] = Field("iid", Scalar())

    /**
      * Commit SHA of the merge request if merge is in progress
      */
    def inProgressMergeCommitSha
        : SelectionBuilder[MergeRequest, Option[String]] =
      Field("inProgressMergeCommitSha", OptionOf(Scalar()))

    /**
      * Labels of the merge request
      */
    def labels[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[LabelConnection, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field(
        "labels",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Deprecated - renamed to defaultMergeCommitMessage
      */
    @deprecated("Renamed to defaultMergeCommitMessage", "")
    def mergeCommitMessage: SelectionBuilder[MergeRequest, Option[String]] =
      Field("mergeCommitMessage", OptionOf(Scalar()))

    /**
      * SHA of the merge request commit (set once merged)
      */
    def mergeCommitSha: SelectionBuilder[MergeRequest, Option[String]] =
      Field("mergeCommitSha", OptionOf(Scalar()))

    /**
      * Error message due to a merge error
      */
    def mergeError: SelectionBuilder[MergeRequest, Option[String]] =
      Field("mergeError", OptionOf(Scalar()))

    /**
      * Indicates if a merge is currently occurring
      */
    def mergeOngoing: SelectionBuilder[MergeRequest, Boolean] =
      Field("mergeOngoing", Scalar())

    /**
      * Status of the merge request
      */
    def mergeStatus: SelectionBuilder[MergeRequest, Option[String]] =
      Field("mergeStatus", OptionOf(Scalar()))

    /**
      * Indicates if the merge has been set to be merged when its pipeline succeeds (MWPS)
      */
    def mergeWhenPipelineSucceeds
        : SelectionBuilder[MergeRequest, Option[Boolean]] =
      Field("mergeWhenPipelineSucceeds", OptionOf(Scalar()))

    /**
      * Indicates if all discussions in the merge request have been resolved, allowing the merge request to be merged
      */
    def mergeableDiscussionsState
        : SelectionBuilder[MergeRequest, Option[Boolean]] =
      Field("mergeableDiscussionsState", OptionOf(Scalar()))

    /**
      * The milestone of the merge request
      */
    def milestone[A](
        innerSelection: SelectionBuilder[Milestone, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field("milestone", OptionOf(Obj(innerSelection)))

    /**
      * All notes on this noteable
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[MergeRequest, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Participants in the merge request
      */
    def participants[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[UserConnection, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field(
        "participants",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Pipelines for the merge request
      */
    def pipelines[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None,
        ref: Option[String] = None,
        sha: Option[String] = None,
        status: Option[PipelineStatusEnum] = None
    )(
        innerSelection: SelectionBuilder[PipelineConnection, A]
    ): SelectionBuilder[MergeRequest, A] =
      Field(
        "pipelines",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last),
          Argument("ref", ref),
          Argument("sha", sha),
          Argument("status", status)
        )
      )

    /**
      * Alias for target_project
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[MergeRequest, A] = Field("project", Obj(innerSelection))

    /**
      * ID of the merge request project
      */
    def projectId: SelectionBuilder[MergeRequest, Int] =
      Field("projectId", Scalar())

    /**
      * Rebase commit SHA of the merge request
      */
    def rebaseCommitSha: SelectionBuilder[MergeRequest, Option[String]] =
      Field("rebaseCommitSha", OptionOf(Scalar()))

    /**
      * Indicates if there is a rebase currently in progress for the merge request
      */
    def rebaseInProgress: SelectionBuilder[MergeRequest, Boolean] =
      Field("rebaseInProgress", Scalar())

    /**
      * Internal reference of the merge request. Returned in shortened format by default
      */
    def reference(
        full: Option[Boolean] = None
    ): SelectionBuilder[MergeRequest, String] =
      Field("reference", Scalar(), arguments = List(Argument("full", full)))

    /**
      * Indicates if the merge request will be rebased
      */
    def shouldBeRebased: SelectionBuilder[MergeRequest, Boolean] =
      Field("shouldBeRebased", Scalar())

    /**
      * Indicates if the source branch of the merge request will be deleted after merge
      */
    def shouldRemoveSourceBranch
        : SelectionBuilder[MergeRequest, Option[Boolean]] =
      Field("shouldRemoveSourceBranch", OptionOf(Scalar()))

    /**
      * Source branch of the merge request
      */
    def sourceBranch: SelectionBuilder[MergeRequest, String] =
      Field("sourceBranch", Scalar())

    /**
      * Indicates if the source branch of the merge request exists
      */
    def sourceBranchExists: SelectionBuilder[MergeRequest, Boolean] =
      Field("sourceBranchExists", Scalar())

    /**
      * Source project of the merge request
      */
    def sourceProject[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[MergeRequest, Option[A]] =
      Field("sourceProject", OptionOf(Obj(innerSelection)))

    /**
      * ID of the merge request source project
      */
    def sourceProjectId: SelectionBuilder[MergeRequest, Option[Int]] =
      Field("sourceProjectId", OptionOf(Scalar()))

    /**
      * State of the merge request
      */
    def state: SelectionBuilder[MergeRequest, MergeRequestState] =
      Field("state", Scalar())

    /**
      * Indicates if the currently logged in user is subscribed to this merge request
      */
    def subscribed: SelectionBuilder[MergeRequest, Boolean] =
      Field("subscribed", Scalar())

    /**
      * Target branch of the merge request
      */
    def targetBranch: SelectionBuilder[MergeRequest, String] =
      Field("targetBranch", Scalar())

    /**
      * Target project of the merge request
      */
    def targetProject[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[MergeRequest, A] =
      Field("targetProject", Obj(innerSelection))

    /**
      * ID of the merge request target project
      */
    def targetProjectId: SelectionBuilder[MergeRequest, Int] =
      Field("targetProjectId", Scalar())

    /**
      * Completion status of tasks
      */
    def taskCompletionStatus[A](
        innerSelection: SelectionBuilder[TaskCompletionStatus, A]
    ): SelectionBuilder[MergeRequest, A] =
      Field("taskCompletionStatus", Obj(innerSelection))

    /**
      * Time estimate of the merge request
      */
    def timeEstimate: SelectionBuilder[MergeRequest, Int] =
      Field("timeEstimate", Scalar())

    /**
      * Title of the merge request
      */
    def title: SelectionBuilder[MergeRequest, String] = Field("title", Scalar())

    /**
      * The GitLab Flavored Markdown rendering of `title`
      */
    def titleHtml: SelectionBuilder[MergeRequest, Option[String]] =
      Field("titleHtml", OptionOf(Scalar()))

    /**
      * Total time reported as spent on the merge request
      */
    def totalTimeSpent: SelectionBuilder[MergeRequest, Int] =
      Field("totalTimeSpent", Scalar())

    /**
      * Timestamp of when the merge request was last updated
      */
    def updatedAt: SelectionBuilder[MergeRequest, Time] =
      Field("updatedAt", Scalar())

    /**
      * Number of upvotes for the merge request
      */
    def upvotes: SelectionBuilder[MergeRequest, Int] =
      Field("upvotes", Scalar())

    /**
      * User notes count of the merge request
      */
    def userNotesCount: SelectionBuilder[MergeRequest, Option[Int]] =
      Field("userNotesCount", OptionOf(Scalar()))

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[MergeRequestPermissions, A]
    ): SelectionBuilder[MergeRequest, A] =
      Field("userPermissions", Obj(innerSelection))

    /**
      * Web URL of the merge request
      */
    def webUrl: SelectionBuilder[MergeRequest, Option[String]] =
      Field("webUrl", OptionOf(Scalar()))

    /**
      * Indicates if the merge request is a work in progress (WIP)
      */
    def workInProgress: SelectionBuilder[MergeRequest, Boolean] =
      Field("workInProgress", Scalar())
  }

  type MergeRequestConnection
  object MergeRequestConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[MergeRequestEdge, A]
    ): SelectionBuilder[MergeRequestConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[MergeRequestConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type MergeRequestEdge
  object MergeRequestEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[MergeRequestEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type MergeRequestPermissions
  object MergeRequestPermissions {

    /**
      * Indicates the user can perform `admin_merge_request` on this resource
      */
    def adminMergeRequest: SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("adminMergeRequest", Scalar())

    /**
      * Indicates the user can perform `cherry_pick_on_current_merge_request` on this resource
      */
    def cherryPickOnCurrentMergeRequest
        : SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("cherryPickOnCurrentMergeRequest", Scalar())

    /**
      * Indicates the user can perform `create_note` on this resource
      */
    def createNote: SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("createNote", Scalar())

    /**
      * Indicates the user can perform `push_to_source_branch` on this resource
      */
    def pushToSourceBranch: SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("pushToSourceBranch", Scalar())

    /**
      * Indicates the user can perform `read_merge_request` on this resource
      */
    def readMergeRequest: SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("readMergeRequest", Scalar())

    /**
      * Indicates the user can perform `remove_source_branch` on this resource
      */
    def removeSourceBranch: SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("removeSourceBranch", Scalar())

    /**
      * Indicates the user can perform `revert_on_current_merge_request` on this resource
      */
    def revertOnCurrentMergeRequest
        : SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("revertOnCurrentMergeRequest", Scalar())

    /**
      * Indicates the user can perform `update_merge_request` on this resource
      */
    def updateMergeRequest: SelectionBuilder[MergeRequestPermissions, Boolean] =
      Field("updateMergeRequest", Scalar())
  }

  type MergeRequestSetAssigneesPayload
  object MergeRequestSetAssigneesPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MergeRequestSetAssigneesPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors
        : SelectionBuilder[MergeRequestSetAssigneesPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The merge request after mutation
      */
    def mergeRequest[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestSetAssigneesPayload, Option[A]] =
      Field("mergeRequest", OptionOf(Obj(innerSelection)))
  }

  type MergeRequestSetLabelsPayload
  object MergeRequestSetLabelsPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MergeRequestSetLabelsPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[MergeRequestSetLabelsPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The merge request after mutation
      */
    def mergeRequest[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestSetLabelsPayload, Option[A]] =
      Field("mergeRequest", OptionOf(Obj(innerSelection)))
  }

  type MergeRequestSetLockedPayload
  object MergeRequestSetLockedPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MergeRequestSetLockedPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[MergeRequestSetLockedPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The merge request after mutation
      */
    def mergeRequest[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestSetLockedPayload, Option[A]] =
      Field("mergeRequest", OptionOf(Obj(innerSelection)))
  }

  type MergeRequestSetMilestonePayload
  object MergeRequestSetMilestonePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MergeRequestSetMilestonePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors
        : SelectionBuilder[MergeRequestSetMilestonePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The merge request after mutation
      */
    def mergeRequest[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestSetMilestonePayload, Option[A]] =
      Field("mergeRequest", OptionOf(Obj(innerSelection)))
  }

  type MergeRequestSetSubscriptionPayload
  object MergeRequestSetSubscriptionPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MergeRequestSetSubscriptionPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors
        : SelectionBuilder[MergeRequestSetSubscriptionPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The merge request after mutation
      */
    def mergeRequest[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestSetSubscriptionPayload, Option[A]] =
      Field("mergeRequest", OptionOf(Obj(innerSelection)))
  }

  type MergeRequestSetWipPayload
  object MergeRequestSetWipPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[MergeRequestSetWipPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[MergeRequestSetWipPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The merge request after mutation
      */
    def mergeRequest[A](
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[MergeRequestSetWipPayload, Option[A]] =
      Field("mergeRequest", OptionOf(Obj(innerSelection)))
  }

  type Metadata
  object Metadata {

    /**
      * Revision
      */
    def revision: SelectionBuilder[Metadata, String] =
      Field("revision", Scalar())

    /**
      * Version
      */
    def version: SelectionBuilder[Metadata, String] = Field("version", Scalar())
  }

  type Milestone
  object Milestone {

    /**
      * Timestamp of milestone creation
      */
    def createdAt: SelectionBuilder[Milestone, Time] =
      Field("createdAt", Scalar())

    /**
      * Description of the milestone
      */
    def description: SelectionBuilder[Milestone, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * Timestamp of the milestone due date
      */
    def dueDate: SelectionBuilder[Milestone, Option[Time]] =
      Field("dueDate", OptionOf(Scalar()))

    /**
      * ID of the milestone
      */
    def id: SelectionBuilder[Milestone, String] = Field("id", Scalar())

    /**
      * Timestamp of the milestone start date
      */
    def startDate: SelectionBuilder[Milestone, Option[Time]] =
      Field("startDate", OptionOf(Scalar()))

    /**
      * State of the milestone
      */
    def state: SelectionBuilder[Milestone, MilestoneStateEnum] =
      Field("state", Scalar())

    /**
      * Title of the milestone
      */
    def title: SelectionBuilder[Milestone, String] = Field("title", Scalar())

    /**
      * Timestamp of last milestone update
      */
    def updatedAt: SelectionBuilder[Milestone, Time] =
      Field("updatedAt", Scalar())

    /**
      * Web path of the milestone
      */
    def webPath: SelectionBuilder[Milestone, String] =
      Field("webPath", Scalar())
  }

  type MilestoneConnection
  object MilestoneConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[MilestoneEdge, A]
    ): SelectionBuilder[MilestoneConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Milestone, A]
    ): SelectionBuilder[MilestoneConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[MilestoneConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type MilestoneEdge
  object MilestoneEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[MilestoneEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Milestone, A]
    ): SelectionBuilder[MilestoneEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Namespace
  object Namespace {

    /**
      * Description of the namespace
      */
    def description: SelectionBuilder[Namespace, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[Namespace, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Full name of the namespace
      */
    def fullName: SelectionBuilder[Namespace, String] =
      Field("fullName", Scalar())

    /**
      * Full path of the namespace
      */
    def fullPath: SelectionBuilder[Namespace, String] =
      Field("fullPath", Scalar())

    /**
      * ID of the namespace
      */
    def id: SelectionBuilder[Namespace, String] = Field("id", Scalar())

    /**
      * Indicates if Large File Storage (LFS) is enabled for namespace
      */
    def lfsEnabled: SelectionBuilder[Namespace, Option[Boolean]] =
      Field("lfsEnabled", OptionOf(Scalar()))

    /**
      * Name of the namespace
      */
    def name: SelectionBuilder[Namespace, String] = Field("name", Scalar())

    /**
      * Path of the namespace
      */
    def path: SelectionBuilder[Namespace, String] = Field("path", Scalar())

    /**
      * Projects within this namespace
      */
    def projects[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        includeSubgroups: Option[Boolean] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[ProjectConnection, A]
    ): SelectionBuilder[Namespace, A] =
      Field(
        "projects",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("includeSubgroups", includeSubgroups),
          Argument("last", last)
        )
      )

    /**
      * Indicates if users can request access to namespace
      */
    def requestAccessEnabled: SelectionBuilder[Namespace, Option[Boolean]] =
      Field("requestAccessEnabled", OptionOf(Scalar()))

    /**
      * Aggregated storage statistics of the namespace. Only available for root namespaces
      */
    def rootStorageStatistics[A](
        innerSelection: SelectionBuilder[RootStorageStatistics, A]
    ): SelectionBuilder[Namespace, Option[A]] =
      Field("rootStorageStatistics", OptionOf(Obj(innerSelection)))

    /**
      * Visibility of the namespace
      */
    def visibility: SelectionBuilder[Namespace, Option[String]] =
      Field("visibility", OptionOf(Scalar()))
  }

  type Note
  object Note {

    /**
      * User who wrote this note
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Note, A] = Field("author", Obj(innerSelection))

    /**
      * Content of the note
      */
    def body: SelectionBuilder[Note, String] = Field("body", Scalar())

    /**
      * The GitLab Flavored Markdown rendering of `note`
      */
    def bodyHtml: SelectionBuilder[Note, Option[String]] =
      Field("bodyHtml", OptionOf(Scalar()))

    /**
      * Timestamp of the note creation
      */
    def createdAt: SelectionBuilder[Note, Time] = Field("createdAt", Scalar())

    /**
      * The discussion this note is a part of
      */
    def discussion[A](
        innerSelection: SelectionBuilder[Discussion, A]
    ): SelectionBuilder[Note, Option[A]] =
      Field("discussion", OptionOf(Obj(innerSelection)))

    /**
      * ID of the note
      */
    def id: SelectionBuilder[Note, String] = Field("id", Scalar())

    /**
      * The position of this note on a diff
      */
    def position[A](
        innerSelection: SelectionBuilder[DiffPosition, A]
    ): SelectionBuilder[Note, Option[A]] =
      Field("position", OptionOf(Obj(innerSelection)))

    /**
      * Project associated with the note
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[Note, Option[A]] =
      Field("project", OptionOf(Obj(innerSelection)))

    /**
      * Indicates if this note can be resolved. That is, if it is a resolvable discussion or simply a standalone note
      */
    def resolvable: SelectionBuilder[Note, Boolean] =
      Field("resolvable", Scalar())

    /**
      * Timestamp of the note's resolution
      */
    def resolvedAt: SelectionBuilder[Note, Option[Time]] =
      Field("resolvedAt", OptionOf(Scalar()))

    /**
      * User that resolved the discussion
      */
    def resolvedBy[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Note, Option[A]] =
      Field("resolvedBy", OptionOf(Obj(innerSelection)))

    /**
      * Indicates whether this note was created by the system or by a user
      */
    def system: SelectionBuilder[Note, Boolean] = Field("system", Scalar())

    /**
      * Timestamp of the note's last activity
      */
    def updatedAt: SelectionBuilder[Note, Time] = Field("updatedAt", Scalar())

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[NotePermissions, A]
    ): SelectionBuilder[Note, A] = Field("userPermissions", Obj(innerSelection))
  }

  type NoteConnection
  object NoteConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[NoteEdge, A]
    ): SelectionBuilder[NoteConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[NoteConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[NoteConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type NoteEdge
  object NoteEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[NoteEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[NoteEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type NotePermissions
  object NotePermissions {

    /**
      * Indicates the user can perform `admin_note` on this resource
      */
    def adminNote: SelectionBuilder[NotePermissions, Boolean] =
      Field("adminNote", Scalar())

    /**
      * Indicates the user can perform `award_emoji` on this resource
      */
    def awardEmoji: SelectionBuilder[NotePermissions, Boolean] =
      Field("awardEmoji", Scalar())

    /**
      * Indicates the user can perform `create_note` on this resource
      */
    def createNote: SelectionBuilder[NotePermissions, Boolean] =
      Field("createNote", Scalar())

    /**
      * Indicates the user can perform `read_note` on this resource
      */
    def readNote: SelectionBuilder[NotePermissions, Boolean] =
      Field("readNote", Scalar())

    /**
      * Indicates the user can perform `resolve_note` on this resource
      */
    def resolveNote: SelectionBuilder[NotePermissions, Boolean] =
      Field("resolveNote", Scalar())
  }

  type PageInfo
  object PageInfo {

    /**
      * When paginating forwards, the cursor to continue.
      */
    def endCursor: SelectionBuilder[PageInfo, Option[String]] =
      Field("endCursor", OptionOf(Scalar()))

    /**
      * When paginating forwards, are there more items?
      */
    def hasNextPage: SelectionBuilder[PageInfo, Boolean] =
      Field("hasNextPage", Scalar())

    /**
      * When paginating backwards, are there more items?
      */
    def hasPreviousPage: SelectionBuilder[PageInfo, Boolean] =
      Field("hasPreviousPage", Scalar())

    /**
      * When paginating backwards, the cursor to continue.
      */
    def startCursor: SelectionBuilder[PageInfo, Option[String]] =
      Field("startCursor", OptionOf(Scalar()))
  }

  type Pipeline
  object Pipeline {

    /**
      * Base SHA of the source branch
      */
    def beforeSha: SelectionBuilder[Pipeline, Option[String]] =
      Field("beforeSha", OptionOf(Scalar()))

    /**
      * Timestamp of the pipeline's commit
      */
    def committedAt: SelectionBuilder[Pipeline, Option[Time]] =
      Field("committedAt", OptionOf(Scalar()))

    /**
      * Coverage percentage
      */
    def coverage: SelectionBuilder[Pipeline, Option[Double]] =
      Field("coverage", OptionOf(Scalar()))

    /**
      * Timestamp of the pipeline's creation
      */
    def createdAt: SelectionBuilder[Pipeline, Time] =
      Field("createdAt", Scalar())

    /**
      * Detailed status of the pipeline
      */
    def detailedStatus[A](
        innerSelection: SelectionBuilder[DetailedStatus, A]
    ): SelectionBuilder[Pipeline, A] =
      Field("detailedStatus", Obj(innerSelection))

    /**
      * Duration of the pipeline in seconds
      */
    def duration: SelectionBuilder[Pipeline, Option[Int]] =
      Field("duration", OptionOf(Scalar()))

    /**
      * Timestamp of the pipeline's completion
      */
    def finishedAt: SelectionBuilder[Pipeline, Option[Time]] =
      Field("finishedAt", OptionOf(Scalar()))

    /**
      * ID of the pipeline
      */
    def id: SelectionBuilder[Pipeline, String] = Field("id", Scalar())

    /**
      * Internal ID of the pipeline
      */
    def iid: SelectionBuilder[Pipeline, String] = Field("iid", Scalar())

    /**
      * SHA of the pipeline's commit
      */
    def sha: SelectionBuilder[Pipeline, String] = Field("sha", Scalar())

    /**
      * Timestamp when the pipeline was started
      */
    def startedAt: SelectionBuilder[Pipeline, Option[Time]] =
      Field("startedAt", OptionOf(Scalar()))

    /**
      * Status of the pipeline (CREATED, WAITING_FOR_RESOURCE, PREPARING, PENDING,
RUNNING, FAILED, SUCCESS, CANCELED, SKIPPED, MANUAL, SCHEDULED)
      */
    def status: SelectionBuilder[Pipeline, PipelineStatusEnum] =
      Field("status", Scalar())

    /**
      * Timestamp of the pipeline's last activity
      */
    def updatedAt: SelectionBuilder[Pipeline, Time] =
      Field("updatedAt", Scalar())

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[PipelinePermissions, A]
    ): SelectionBuilder[Pipeline, A] =
      Field("userPermissions", Obj(innerSelection))
  }

  type PipelineConnection
  object PipelineConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[PipelineEdge, A]
    ): SelectionBuilder[PipelineConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Pipeline, A]
    ): SelectionBuilder[PipelineConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[PipelineConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type PipelineEdge
  object PipelineEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[PipelineEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Pipeline, A]
    ): SelectionBuilder[PipelineEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type PipelinePermissions
  object PipelinePermissions {

    /**
      * Indicates the user can perform `admin_pipeline` on this resource
      */
    def adminPipeline: SelectionBuilder[PipelinePermissions, Boolean] =
      Field("adminPipeline", Scalar())

    /**
      * Indicates the user can perform `destroy_pipeline` on this resource
      */
    def destroyPipeline: SelectionBuilder[PipelinePermissions, Boolean] =
      Field("destroyPipeline", Scalar())

    /**
      * Indicates the user can perform `update_pipeline` on this resource
      */
    def updatePipeline: SelectionBuilder[PipelinePermissions, Boolean] =
      Field("updatePipeline", Scalar())
  }

  type Project
  object Project {

    /**
      * Indicates the archived status of the project
      */
    def archived: SelectionBuilder[Project, Option[Boolean]] =
      Field("archived", OptionOf(Scalar()))

    /**
      * Indicates if issues referenced by merge requests and commits within the default branch are closed automatically
      */
    def autocloseReferencedIssues: SelectionBuilder[Project, Option[Boolean]] =
      Field("autocloseReferencedIssues", OptionOf(Scalar()))

    /**
      * URL to avatar image file of the project
      */
    def avatarUrl: SelectionBuilder[Project, Option[String]] =
      Field("avatarUrl", OptionOf(Scalar()))

    /**
      * A single board of the project
      */
    def board[A](id: Option[String] = None)(
        innerSelection: SelectionBuilder[Board, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "board",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Boards of the project
      */
    def boards[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        id: Option[String] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[BoardConnection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "boards",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("id", id),
          Argument("last", last)
        )
      )

    /**
      * Indicates if the project stores Docker container images in a container registry
      */
    def containerRegistryEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("containerRegistryEnabled", OptionOf(Scalar()))

    /**
      * Timestamp of the project creation
      */
    def createdAt: SelectionBuilder[Project, Option[Time]] =
      Field("createdAt", OptionOf(Scalar()))

    /**
      * Short description of the project
      */
    def description: SelectionBuilder[Project, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[Project, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * Environments of the project
      */
    def environments[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None,
        name: Option[String] = None,
        search: Option[String] = None
    )(
        innerSelection: SelectionBuilder[EnvironmentConnection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "environments",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last),
          Argument("name", name),
          Argument("search", search)
        )
      )

    /**
      * Number of times the project has been forked
      */
    def forksCount: SelectionBuilder[Project, Int] =
      Field("forksCount", Scalar())

    /**
      * Full path of the project
      */
    def fullPath: SelectionBuilder[Project, String] =
      Field("fullPath", Scalar())

    /**
      * Grafana integration details for the project
      */
    def grafanaIntegration[A](
        innerSelection: SelectionBuilder[GrafanaIntegration, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field("grafanaIntegration", OptionOf(Obj(innerSelection)))

    /**
      * Group of the project
      */
    def group[A](
        innerSelection: SelectionBuilder[Group, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field("group", OptionOf(Obj(innerSelection)))

    /**
      * URL to connect to the project via HTTPS
      */
    def httpUrlToRepo: SelectionBuilder[Project, Option[String]] =
      Field("httpUrlToRepo", OptionOf(Scalar()))

    /**
      * ID of the project
      */
    def id: SelectionBuilder[Project, String] = Field("id", Scalar())

    /**
      * Status of project import background job of the project
      */
    def importStatus: SelectionBuilder[Project, Option[String]] =
      Field("importStatus", OptionOf(Scalar()))

    /**
      * A single issue of the project
      */
    def issue[A](
        assigneeId: Option[String] = None,
        assigneeUsername: Option[String] = None,
        closedAfter: Option[Time] = None,
        closedBefore: Option[Time] = None,
        createdAfter: Option[Time] = None,
        createdBefore: Option[Time] = None,
        iid: Option[String] = None,
        iids: Option[List[String]] = None,
        labelName: Option[List[Option[String]]] = None,
        milestoneTitle: Option[List[Option[String]]] = None,
        search: Option[String] = None,
        sort: Option[IssueSort] = None,
        state: Option[IssuableState] = None,
        updatedAfter: Option[Time] = None,
        updatedBefore: Option[Time] = None
    )(
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "issue",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("assigneeId", assigneeId),
          Argument("assigneeUsername", assigneeUsername),
          Argument("closedAfter", closedAfter),
          Argument("closedBefore", closedBefore),
          Argument("createdAfter", createdAfter),
          Argument("createdBefore", createdBefore),
          Argument("iid", iid),
          Argument("iids", iids),
          Argument("labelName", labelName),
          Argument("milestoneTitle", milestoneTitle),
          Argument("search", search),
          Argument("sort", sort),
          Argument("state", state),
          Argument("updatedAfter", updatedAfter),
          Argument("updatedBefore", updatedBefore)
        )
      )

    /**
      * Issues of the project
      */
    def issues[A](
        after: Option[String] = None,
        assigneeId: Option[String] = None,
        assigneeUsername: Option[String] = None,
        before: Option[String] = None,
        closedAfter: Option[Time] = None,
        closedBefore: Option[Time] = None,
        createdAfter: Option[Time] = None,
        createdBefore: Option[Time] = None,
        first: Option[Int] = None,
        iid: Option[String] = None,
        iids: Option[List[String]] = None,
        labelName: Option[List[Option[String]]] = None,
        last: Option[Int] = None,
        milestoneTitle: Option[List[Option[String]]] = None,
        search: Option[String] = None,
        sort: Option[IssueSort] = None,
        state: Option[IssuableState] = None,
        updatedAfter: Option[Time] = None,
        updatedBefore: Option[Time] = None
    )(
        innerSelection: SelectionBuilder[IssueConnection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "issues",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("assigneeId", assigneeId),
          Argument("assigneeUsername", assigneeUsername),
          Argument("before", before),
          Argument("closedAfter", closedAfter),
          Argument("closedBefore", closedBefore),
          Argument("createdAfter", createdAfter),
          Argument("createdBefore", createdBefore),
          Argument("first", first),
          Argument("iid", iid),
          Argument("iids", iids),
          Argument("labelName", labelName),
          Argument("last", last),
          Argument("milestoneTitle", milestoneTitle),
          Argument("search", search),
          Argument("sort", sort),
          Argument("state", state),
          Argument("updatedAfter", updatedAfter),
          Argument("updatedBefore", updatedBefore)
        )
      )

    /**
      * (deprecated) Does this project have issues enabled?. Use `issues_access_level` instead
      */
    def issuesEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("issuesEnabled", OptionOf(Scalar()))

    /**
      * (deprecated) Enable jobs for this project. Use `builds_access_level` instead
      */
    def jobsEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("jobsEnabled", OptionOf(Scalar()))

    /**
      * Timestamp of the project last activity
      */
    def lastActivityAt: SelectionBuilder[Project, Option[Time]] =
      Field("lastActivityAt", OptionOf(Scalar()))

    /**
      * Indicates if the project has Large File Storage (LFS) enabled
      */
    def lfsEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("lfsEnabled", OptionOf(Scalar()))

    /**
      * A single merge request of the project
      */
    def mergeRequest[A](
        iid: Option[String] = None,
        iids: Option[List[String]] = None
    )(
        innerSelection: SelectionBuilder[MergeRequest, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "mergeRequest",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("iid", iid), Argument("iids", iids))
      )

    /**
      * Merge requests of the project
      */
    def mergeRequests[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        iid: Option[String] = None,
        iids: Option[List[String]] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[MergeRequestConnection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "mergeRequests",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("iid", iid),
          Argument("iids", iids),
          Argument("last", last)
        )
      )

    /**
      * (deprecated) Does this project have merge_requests enabled?. Use `merge_requests_access_level` instead
      */
    def mergeRequestsEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("mergeRequestsEnabled", OptionOf(Scalar()))

    /**
      * Indicates if no merge commits should be created and all merges should instead
be fast-forwarded, which means that merging is only allowed if the branch
could be fast-forwarded.
      */
    def mergeRequestsFfOnlyEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("mergeRequestsFfOnlyEnabled", OptionOf(Scalar()))

    /**
      * Name of the project (without namespace)
      */
    def name: SelectionBuilder[Project, String] = Field("name", Scalar())

    /**
      * Full name of the project with its namespace
      */
    def nameWithNamespace: SelectionBuilder[Project, String] =
      Field("nameWithNamespace", Scalar())

    /**
      * Namespace of the project
      */
    def namespace[A](
        innerSelection: SelectionBuilder[Namespace, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field("namespace", OptionOf(Obj(innerSelection)))

    /**
      * Indicates if merge requests of the project can only be merged when all the discussions are resolved
      */
    def onlyAllowMergeIfAllDiscussionsAreResolved
        : SelectionBuilder[Project, Option[Boolean]] =
      Field("onlyAllowMergeIfAllDiscussionsAreResolved", OptionOf(Scalar()))

    /**
      * Indicates if merge requests of the project can only be merged with successful jobs
      */
    def onlyAllowMergeIfPipelineSucceeds
        : SelectionBuilder[Project, Option[Boolean]] =
      Field("onlyAllowMergeIfPipelineSucceeds", OptionOf(Scalar()))

    /**
      * Number of open issues for the project
      */
    def openIssuesCount: SelectionBuilder[Project, Option[Int]] =
      Field("openIssuesCount", OptionOf(Scalar()))

    /**
      * Path of the project
      */
    def path: SelectionBuilder[Project, String] = Field("path", Scalar())

    /**
      * Build pipelines of the project
      */
    def pipelines[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None,
        ref: Option[String] = None,
        sha: Option[String] = None,
        status: Option[PipelineStatusEnum] = None
    )(
        innerSelection: SelectionBuilder[PipelineConnection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "pipelines",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last),
          Argument("ref", ref),
          Argument("sha", sha),
          Argument("status", status)
        )
      )

    /**
      * Indicates if a link to create or view a merge request should display after a
push to Git repositories of the project from the command line
      */
    def printingMergeRequestLinkEnabled
        : SelectionBuilder[Project, Option[Boolean]] =
      Field("printingMergeRequestLinkEnabled", OptionOf(Scalar()))

    /**
      * Indicates if there is public access to pipelines and job details of the project, including output logs and artifacts
      */
    def publicJobs: SelectionBuilder[Project, Option[Boolean]] =
      Field("publicJobs", OptionOf(Scalar()))

    /**
      * Indicates if `Delete source branch` option should be enabled by default for all new merge requests of the project
      */
    def removeSourceBranchAfterMerge
        : SelectionBuilder[Project, Option[Boolean]] =
      Field("removeSourceBranchAfterMerge", OptionOf(Scalar()))

    /**
      * Git repository of the project
      */
    def repository[A](
        innerSelection: SelectionBuilder[Repository, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field("repository", OptionOf(Obj(innerSelection)))

    /**
      * Indicates if users can request member access to the project
      */
    def requestAccessEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("requestAccessEnabled", OptionOf(Scalar()))

    /**
      * Detailed version of a Sentry error on the project
      */
    def sentryDetailedError[A](id: String)(
        innerSelection: SelectionBuilder[SentryDetailedError, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "sentryDetailedError",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Paginated collection of Sentry errors on the project
      */
    def sentryErrors[A](
        innerSelection: SelectionBuilder[SentryErrorCollection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field("sentryErrors", OptionOf(Obj(innerSelection)))

    /**
      * E-mail address of the service desk.
      */
    def serviceDeskAddress: SelectionBuilder[Project, Option[String]] =
      Field("serviceDeskAddress", OptionOf(Scalar()))

    /**
      * Indicates if the project has service desk enabled.
      */
    def serviceDeskEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("serviceDeskEnabled", OptionOf(Scalar()))

    /**
      * Indicates if shared runners are enabled on the project
      */
    def sharedRunnersEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("sharedRunnersEnabled", OptionOf(Scalar()))

    /**
      * Snippets of the project
      */
    def snippets[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        ids: Option[List[String]] = None,
        last: Option[Int] = None,
        visibility: Option[VisibilityScopesEnum] = None
    )(
        innerSelection: SelectionBuilder[SnippetConnection, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field(
        "snippets",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("ids", ids),
          Argument("last", last),
          Argument("visibility", visibility)
        )
      )

    /**
      * (deprecated) Does this project have snippets enabled?. Use `snippets_access_level` instead
      */
    def snippetsEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("snippetsEnabled", OptionOf(Scalar()))

    /**
      * URL to connect to the project via SSH
      */
    def sshUrlToRepo: SelectionBuilder[Project, Option[String]] =
      Field("sshUrlToRepo", OptionOf(Scalar()))

    /**
      * Number of times the project has been starred
      */
    def starCount: SelectionBuilder[Project, Int] = Field("starCount", Scalar())

    /**
      * Statistics of the project
      */
    def statistics[A](
        innerSelection: SelectionBuilder[ProjectStatistics, A]
    ): SelectionBuilder[Project, Option[A]] =
      Field("statistics", OptionOf(Obj(innerSelection)))

    /**
      * The commit message used to apply merge request suggestions
      */
    def suggestionCommitMessage: SelectionBuilder[Project, Option[String]] =
      Field("suggestionCommitMessage", OptionOf(Scalar()))

    /**
      * List of project tags
      */
    def tagList: SelectionBuilder[Project, Option[String]] =
      Field("tagList", OptionOf(Scalar()))

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[ProjectPermissions, A]
    ): SelectionBuilder[Project, A] =
      Field("userPermissions", Obj(innerSelection))

    /**
      * Visibility of the project
      */
    def visibility: SelectionBuilder[Project, Option[String]] =
      Field("visibility", OptionOf(Scalar()))

    /**
      * Web URL of the project
      */
    def webUrl: SelectionBuilder[Project, Option[String]] =
      Field("webUrl", OptionOf(Scalar()))

    /**
      * (deprecated) Does this project have wiki enabled?. Use `wiki_access_level` instead
      */
    def wikiEnabled: SelectionBuilder[Project, Option[Boolean]] =
      Field("wikiEnabled", OptionOf(Scalar()))
  }

  type ProjectConnection
  object ProjectConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[ProjectEdge, A]
    ): SelectionBuilder[ProjectConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[ProjectConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[ProjectConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type ProjectEdge
  object ProjectEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[ProjectEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[ProjectEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type ProjectPermissions
  object ProjectPermissions {

    /**
      * Indicates the user can perform `admin_operations` on this resource
      */
    def adminOperations: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("adminOperations", Scalar())

    /**
      * Indicates the user can perform `admin_project` on this resource
      */
    def adminProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("adminProject", Scalar())

    /**
      * Indicates the user can perform `admin_remote_mirror` on this resource
      */
    def adminRemoteMirror: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("adminRemoteMirror", Scalar())

    /**
      * Indicates the user can perform `admin_wiki` on this resource
      */
    def adminWiki: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("adminWiki", Scalar())

    /**
      * Indicates the user can perform `archive_project` on this resource
      */
    def archiveProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("archiveProject", Scalar())

    /**
      * Indicates the user can perform `change_namespace` on this resource
      */
    def changeNamespace: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("changeNamespace", Scalar())

    /**
      * Indicates the user can perform `change_visibility_level` on this resource
      */
    def changeVisibilityLevel: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("changeVisibilityLevel", Scalar())

    /**
      * Indicates the user can perform `create_deployment` on this resource
      */
    def createDeployment: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createDeployment", Scalar())

    /**
      * Indicates the user can perform `create_design` on this resource
      */
    def createDesign: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createDesign", Scalar())

    /**
      * Indicates the user can perform `create_issue` on this resource
      */
    def createIssue: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createIssue", Scalar())

    /**
      * Indicates the user can perform `create_label` on this resource
      */
    def createLabel: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createLabel", Scalar())

    /**
      * Indicates the user can perform `create_merge_request_from` on this resource
      */
    def createMergeRequestFrom: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createMergeRequestFrom", Scalar())

    /**
      * Indicates the user can perform `create_merge_request_in` on this resource
      */
    def createMergeRequestIn: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createMergeRequestIn", Scalar())

    /**
      * Indicates the user can perform `create_pages` on this resource
      */
    def createPages: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createPages", Scalar())

    /**
      * Indicates the user can perform `create_pipeline` on this resource
      */
    def createPipeline: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createPipeline", Scalar())

    /**
      * Indicates the user can perform `create_pipeline_schedule` on this resource
      */
    def createPipelineSchedule: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createPipelineSchedule", Scalar())

    /**
      * Indicates the user can perform `create_snippet` on this resource
      */
    def createSnippet: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createSnippet", Scalar())

    /**
      * Indicates the user can perform `create_wiki` on this resource
      */
    def createWiki: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("createWiki", Scalar())

    /**
      * Indicates the user can perform `destroy_design` on this resource
      */
    def destroyDesign: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("destroyDesign", Scalar())

    /**
      * Indicates the user can perform `destroy_pages` on this resource
      */
    def destroyPages: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("destroyPages", Scalar())

    /**
      * Indicates the user can perform `destroy_wiki` on this resource
      */
    def destroyWiki: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("destroyWiki", Scalar())

    /**
      * Indicates the user can perform `download_code` on this resource
      */
    def downloadCode: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("downloadCode", Scalar())

    /**
      * Indicates the user can perform `download_wiki_code` on this resource
      */
    def downloadWikiCode: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("downloadWikiCode", Scalar())

    /**
      * Indicates the user can perform `fork_project` on this resource
      */
    def forkProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("forkProject", Scalar())

    /**
      * Indicates the user can perform `push_code` on this resource
      */
    def pushCode: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("pushCode", Scalar())

    /**
      * Indicates the user can perform `push_to_delete_protected_branch` on this resource
      */
    def pushToDeleteProtectedBranch
        : SelectionBuilder[ProjectPermissions, Boolean] =
      Field("pushToDeleteProtectedBranch", Scalar())

    /**
      * Indicates the user can perform `read_commit_status` on this resource
      */
    def readCommitStatus: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readCommitStatus", Scalar())

    /**
      * Indicates the user can perform `read_cycle_analytics` on this resource
      */
    def readCycleAnalytics: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readCycleAnalytics", Scalar())

    /**
      * Indicates the user can perform `read_design` on this resource
      */
    def readDesign: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readDesign", Scalar())

    /**
      * Indicates the user can perform `read_merge_request` on this resource
      */
    def readMergeRequest: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readMergeRequest", Scalar())

    /**
      * Indicates the user can perform `read_pages_content` on this resource
      */
    def readPagesContent: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readPagesContent", Scalar())

    /**
      * Indicates the user can perform `read_project` on this resource
      */
    def readProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readProject", Scalar())

    /**
      * Indicates the user can perform `read_project_member` on this resource
      */
    def readProjectMember: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readProjectMember", Scalar())

    /**
      * Indicates the user can perform `read_wiki` on this resource
      */
    def readWiki: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("readWiki", Scalar())

    /**
      * Indicates the user can perform `remove_fork_project` on this resource
      */
    def removeForkProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("removeForkProject", Scalar())

    /**
      * Indicates the user can perform `remove_pages` on this resource
      */
    def removePages: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("removePages", Scalar())

    /**
      * Indicates the user can perform `remove_project` on this resource
      */
    def removeProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("removeProject", Scalar())

    /**
      * Indicates the user can perform `rename_project` on this resource
      */
    def renameProject: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("renameProject", Scalar())

    /**
      * Indicates the user can perform `request_access` on this resource
      */
    def requestAccess: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("requestAccess", Scalar())

    /**
      * Indicates the user can perform `update_pages` on this resource
      */
    def updatePages: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("updatePages", Scalar())

    /**
      * Indicates the user can perform `update_wiki` on this resource
      */
    def updateWiki: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("updateWiki", Scalar())

    /**
      * Indicates the user can perform `upload_file` on this resource
      */
    def uploadFile: SelectionBuilder[ProjectPermissions, Boolean] =
      Field("uploadFile", Scalar())
  }

  type ProjectStatistics
  object ProjectStatistics {

    /**
      * Build artifacts size of the project
      */
    def buildArtifactsSize: SelectionBuilder[ProjectStatistics, Int] =
      Field("buildArtifactsSize", Scalar())

    /**
      * Commit count of the project
      */
    def commitCount: SelectionBuilder[ProjectStatistics, Int] =
      Field("commitCount", Scalar())

    /**
      * Large File Storage (LFS) object size of the project
      */
    def lfsObjectsSize: SelectionBuilder[ProjectStatistics, Int] =
      Field("lfsObjectsSize", Scalar())

    /**
      * Packages size of the project
      */
    def packagesSize: SelectionBuilder[ProjectStatistics, Int] =
      Field("packagesSize", Scalar())

    /**
      * Repository size of the project
      */
    def repositorySize: SelectionBuilder[ProjectStatistics, Int] =
      Field("repositorySize", Scalar())

    /**
      * Storage size of the project
      */
    def storageSize: SelectionBuilder[ProjectStatistics, Int] =
      Field("storageSize", Scalar())

    /**
      * Wiki size of the project
      */
    def wikiSize: SelectionBuilder[ProjectStatistics, Option[Int]] =
      Field("wikiSize", OptionOf(Scalar()))
  }

  type RemoveAwardEmojiPayload
  object RemoveAwardEmojiPayload {

    /**
      * The award emoji after mutation
      */
    def awardEmoji[A](
        innerSelection: SelectionBuilder[AwardEmoji, A]
    ): SelectionBuilder[RemoveAwardEmojiPayload, Option[A]] =
      Field("awardEmoji", OptionOf(Obj(innerSelection)))

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[RemoveAwardEmojiPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[RemoveAwardEmojiPayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type Repository
  object Repository {

    /**
      * Indicates repository has no visible content
      */
    def empty: SelectionBuilder[Repository, Boolean] = Field("empty", Scalar())

    /**
      * Indicates a corresponding Git repository exists on disk
      */
    def exists: SelectionBuilder[Repository, Boolean] =
      Field("exists", Scalar())

    /**
      * Default branch of the repository
      */
    def rootRef: SelectionBuilder[Repository, Option[String]] =
      Field("rootRef", OptionOf(Scalar()))

    /**
      * Tree of the repository
      */
    def tree[A](
        path: Option[String] = None,
        recursive: Option[Boolean] = None,
        ref: Option[String] = None
    )(
        innerSelection: SelectionBuilder[Tree, A]
    ): SelectionBuilder[Repository, Option[A]] =
      Field(
        "tree",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("path", path),
          Argument("recursive", recursive),
          Argument("ref", ref)
        )
      )
  }

  type RootStorageStatistics
  object RootStorageStatistics {

    /**
      * The CI artifacts size in bytes
      */
    def buildArtifactsSize: SelectionBuilder[RootStorageStatistics, Int] =
      Field("buildArtifactsSize", Scalar())

    /**
      * The LFS objects size in bytes
      */
    def lfsObjectsSize: SelectionBuilder[RootStorageStatistics, Int] =
      Field("lfsObjectsSize", Scalar())

    /**
      * The packages size in bytes
      */
    def packagesSize: SelectionBuilder[RootStorageStatistics, Int] =
      Field("packagesSize", Scalar())

    /**
      * The Git repository size in bytes
      */
    def repositorySize: SelectionBuilder[RootStorageStatistics, Int] =
      Field("repositorySize", Scalar())

    /**
      * The total storage in bytes
      */
    def storageSize: SelectionBuilder[RootStorageStatistics, Int] =
      Field("storageSize", Scalar())

    /**
      * The wiki size in bytes
      */
    def wikiSize: SelectionBuilder[RootStorageStatistics, Int] =
      Field("wikiSize", Scalar())
  }

  type SentryDetailedError
  object SentryDetailedError {

    /**
      * Count of occurrences
      */
    def count: SelectionBuilder[SentryDetailedError, Int] =
      Field("count", Scalar())

    /**
      * Culprit of the error
      */
    def culprit: SelectionBuilder[SentryDetailedError, String] =
      Field("culprit", Scalar())

    /**
      * External Base URL of the Sentry Instance
      */
    def externalBaseUrl: SelectionBuilder[SentryDetailedError, String] =
      Field("externalBaseUrl", Scalar())

    /**
      * External URL of the error
      */
    def externalUrl: SelectionBuilder[SentryDetailedError, String] =
      Field("externalUrl", Scalar())

    /**
      * Commit the error was first seen
      */
    def firstReleaseLastCommit
        : SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("firstReleaseLastCommit", OptionOf(Scalar()))

    /**
      * Release version the error was first seen
      */
    def firstReleaseShortVersion
        : SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("firstReleaseShortVersion", OptionOf(Scalar()))

    /**
      * Timestamp when the error was first seen
      */
    def firstSeen: SelectionBuilder[SentryDetailedError, Time] =
      Field("firstSeen", Scalar())

    /**
      * Last 24hr stats of the error
      */
    def frequency[A](
        innerSelection: SelectionBuilder[SentryErrorFrequency, A]
    ): SelectionBuilder[SentryDetailedError, List[A]] =
      Field("frequency", ListOf(Obj(innerSelection)))

    /**
      * GitLab commit SHA attributed to the Error based on the release version
      */
    def gitlabCommit: SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("gitlabCommit", OptionOf(Scalar()))

    /**
      * Path to the GitLab page for the GitLab commit attributed to the error
      */
    def gitlabCommitPath
        : SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("gitlabCommitPath", OptionOf(Scalar()))

    /**
      * URL of GitLab Issue
      */
    def gitlabIssuePath: SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("gitlabIssuePath", OptionOf(Scalar()))

    /**
      * ID (global ID) of the error
      */
    def id: SelectionBuilder[SentryDetailedError, String] =
      Field("id", Scalar())

    /**
      * Commit the error was last seen
      */
    def lastReleaseLastCommit
        : SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("lastReleaseLastCommit", OptionOf(Scalar()))

    /**
      * Release version the error was last seen
      */
    def lastReleaseShortVersion
        : SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("lastReleaseShortVersion", OptionOf(Scalar()))

    /**
      * Timestamp when the error was last seen
      */
    def lastSeen: SelectionBuilder[SentryDetailedError, Time] =
      Field("lastSeen", Scalar())

    /**
      * Sentry metadata message of the error
      */
    def message: SelectionBuilder[SentryDetailedError, Option[String]] =
      Field("message", OptionOf(Scalar()))

    /**
      * ID (Sentry ID) of the error
      */
    def sentryId: SelectionBuilder[SentryDetailedError, String] =
      Field("sentryId", Scalar())

    /**
      * ID of the project (Sentry project)
      */
    def sentryProjectId: SelectionBuilder[SentryDetailedError, String] =
      Field("sentryProjectId", Scalar())

    /**
      * Name of the project affected by the error
      */
    def sentryProjectName: SelectionBuilder[SentryDetailedError, String] =
      Field("sentryProjectName", Scalar())

    /**
      * Slug of the project affected by the error
      */
    def sentryProjectSlug: SelectionBuilder[SentryDetailedError, String] =
      Field("sentryProjectSlug", Scalar())

    /**
      * Short ID (Sentry ID) of the error
      */
    def shortId: SelectionBuilder[SentryDetailedError, String] =
      Field("shortId", Scalar())

    /**
      * Status of the error
      */
    def status: SelectionBuilder[SentryDetailedError, SentryErrorStatus] =
      Field("status", Scalar())

    /**
      * Tags associated with the Sentry Error
      */
    def tags[A](
        innerSelection: SelectionBuilder[SentryErrorTags, A]
    ): SelectionBuilder[SentryDetailedError, A] =
      Field("tags", Obj(innerSelection))

    /**
      * Title of the error
      */
    def title: SelectionBuilder[SentryDetailedError, String] =
      Field("title", Scalar())

    /**
      * Type of the error
      */
    def `type`: SelectionBuilder[SentryDetailedError, String] =
      Field("type", Scalar())

    /**
      * Count of users affected by the error
      */
    def userCount: SelectionBuilder[SentryDetailedError, Int] =
      Field("userCount", Scalar())
  }

  type SentryError
  object SentryError {

    /**
      * Count of occurrences
      */
    def count: SelectionBuilder[SentryError, Int] = Field("count", Scalar())

    /**
      * Culprit of the error
      */
    def culprit: SelectionBuilder[SentryError, String] =
      Field("culprit", Scalar())

    /**
      * External URL of the error
      */
    def externalUrl: SelectionBuilder[SentryError, String] =
      Field("externalUrl", Scalar())

    /**
      * Timestamp when the error was first seen
      */
    def firstSeen: SelectionBuilder[SentryError, Time] =
      Field("firstSeen", Scalar())

    /**
      * Last 24hr stats of the error
      */
    def frequency[A](
        innerSelection: SelectionBuilder[SentryErrorFrequency, A]
    ): SelectionBuilder[SentryError, List[A]] =
      Field("frequency", ListOf(Obj(innerSelection)))

    /**
      * ID (global ID) of the error
      */
    def id: SelectionBuilder[SentryError, String] = Field("id", Scalar())

    /**
      * Timestamp when the error was last seen
      */
    def lastSeen: SelectionBuilder[SentryError, Time] =
      Field("lastSeen", Scalar())

    /**
      * Sentry metadata message of the error
      */
    def message: SelectionBuilder[SentryError, Option[String]] =
      Field("message", OptionOf(Scalar()))

    /**
      * ID (Sentry ID) of the error
      */
    def sentryId: SelectionBuilder[SentryError, String] =
      Field("sentryId", Scalar())

    /**
      * ID of the project (Sentry project)
      */
    def sentryProjectId: SelectionBuilder[SentryError, String] =
      Field("sentryProjectId", Scalar())

    /**
      * Name of the project affected by the error
      */
    def sentryProjectName: SelectionBuilder[SentryError, String] =
      Field("sentryProjectName", Scalar())

    /**
      * Slug of the project affected by the error
      */
    def sentryProjectSlug: SelectionBuilder[SentryError, String] =
      Field("sentryProjectSlug", Scalar())

    /**
      * Short ID (Sentry ID) of the error
      */
    def shortId: SelectionBuilder[SentryError, String] =
      Field("shortId", Scalar())

    /**
      * Status of the error
      */
    def status: SelectionBuilder[SentryError, SentryErrorStatus] =
      Field("status", Scalar())

    /**
      * Title of the error
      */
    def title: SelectionBuilder[SentryError, String] = Field("title", Scalar())

    /**
      * Type of the error
      */
    def `type`: SelectionBuilder[SentryError, String] = Field("type", Scalar())

    /**
      * Count of users affected by the error
      */
    def userCount: SelectionBuilder[SentryError, Int] =
      Field("userCount", Scalar())
  }

  type SentryErrorCollection
  object SentryErrorCollection {

    /**
      * Detailed version of a Sentry error on the project
      */
    def detailedError[A](id: String)(
        innerSelection: SelectionBuilder[SentryDetailedError, A]
    ): SelectionBuilder[SentryErrorCollection, Option[A]] =
      Field(
        "detailedError",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Stack Trace of Sentry Error
      */
    def errorStackTrace[A](id: String)(
        innerSelection: SelectionBuilder[SentryErrorStackTrace, A]
    ): SelectionBuilder[SentryErrorCollection, Option[A]] =
      Field(
        "errorStackTrace",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("id", id))
      )

    /**
      * Collection of Sentry Errors
      */
    def errors[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None,
        searchTerm: Option[String] = None,
        sort: Option[String] = None
    )(
        innerSelection: SelectionBuilder[SentryErrorConnection, A]
    ): SelectionBuilder[SentryErrorCollection, Option[A]] =
      Field(
        "errors",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last),
          Argument("searchTerm", searchTerm),
          Argument("sort", sort)
        )
      )

    /**
      * External URL for Sentry
      */
    def externalUrl: SelectionBuilder[SentryErrorCollection, Option[String]] =
      Field("externalUrl", OptionOf(Scalar()))
  }

  type SentryErrorConnection
  object SentryErrorConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[SentryErrorEdge, A]
    ): SelectionBuilder[SentryErrorConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[SentryError, A]
    ): SelectionBuilder[SentryErrorConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SentryErrorConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type SentryErrorEdge
  object SentryErrorEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[SentryErrorEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[SentryError, A]
    ): SelectionBuilder[SentryErrorEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type SentryErrorFrequency
  object SentryErrorFrequency {

    /**
      * Count of errors received since the previously recorded time
      */
    def count: SelectionBuilder[SentryErrorFrequency, Int] =
      Field("count", Scalar())

    /**
      * Time the error frequency stats were recorded
      */
    def time: SelectionBuilder[SentryErrorFrequency, Time] =
      Field("time", Scalar())
  }

  type SentryErrorStackTrace
  object SentryErrorStackTrace {

    /**
      * Time the stack trace was received by Sentry
      */
    def dateReceived: SelectionBuilder[SentryErrorStackTrace, String] =
      Field("dateReceived", Scalar())

    /**
      * ID of the Sentry error
      */
    def issueId: SelectionBuilder[SentryErrorStackTrace, String] =
      Field("issueId", Scalar())

    /**
      * Stack trace entries for the Sentry error
      */
    def stackTraceEntries[A](
        innerSelection: SelectionBuilder[SentryErrorStackTraceEntry, A]
    ): SelectionBuilder[SentryErrorStackTrace, List[A]] =
      Field("stackTraceEntries", ListOf(Obj(innerSelection)))
  }

  type SentryErrorStackTraceContext
  object SentryErrorStackTraceContext {

    /**
      * Code number of the context
      */
    def code: SelectionBuilder[SentryErrorStackTraceContext, String] =
      Field("code", Scalar())

    /**
      * Line number of the context
      */
    def line: SelectionBuilder[SentryErrorStackTraceContext, Int] =
      Field("line", Scalar())
  }

  type SentryErrorStackTraceEntry
  object SentryErrorStackTraceEntry {

    /**
      * Function in which the Sentry error occurred
      */
    def col: SelectionBuilder[SentryErrorStackTraceEntry, Option[String]] =
      Field("col", OptionOf(Scalar()))

    /**
      * File in which the Sentry error occurred
      */
    def fileName: SelectionBuilder[SentryErrorStackTraceEntry, Option[String]] =
      Field("fileName", OptionOf(Scalar()))

    /**
      * Function in which the Sentry error occurred
      */
    def function: SelectionBuilder[SentryErrorStackTraceEntry, Option[String]] =
      Field("function", OptionOf(Scalar()))

    /**
      * Function in which the Sentry error occurred
      */
    def line: SelectionBuilder[SentryErrorStackTraceEntry, Option[String]] =
      Field("line", OptionOf(Scalar()))

    /**
      * Context of the Sentry error
      */
    def traceContext[A](
        innerSelection: SelectionBuilder[SentryErrorStackTraceContext, A]
    ): SelectionBuilder[SentryErrorStackTraceEntry, Option[List[A]]] =
      Field("traceContext", OptionOf(ListOf(Obj(innerSelection))))
  }

  type SentryErrorTags
  object SentryErrorTags {

    /**
      * Severity level of the Sentry Error
      */
    def level: SelectionBuilder[SentryErrorTags, Option[String]] =
      Field("level", OptionOf(Scalar()))

    /**
      * Logger of the Sentry Error
      */
    def logger: SelectionBuilder[SentryErrorTags, Option[String]] =
      Field("logger", OptionOf(Scalar()))
  }

  type Snippet
  object Snippet {

    /**
      * The owner of the snippet
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Snippet, A] = Field("author", Obj(innerSelection))

    /**
      * Snippet blob
      */
    def blob[A](
        innerSelection: SelectionBuilder[SnippetBlob, A]
    ): SelectionBuilder[Snippet, A] = Field("blob", Obj(innerSelection))

    /**
      * Timestamp this snippet was created
      */
    def createdAt: SelectionBuilder[Snippet, Time] =
      Field("createdAt", Scalar())

    /**
      * Description of the snippet
      */
    def description: SelectionBuilder[Snippet, Option[String]] =
      Field("description", OptionOf(Scalar()))

    /**
      * The GitLab Flavored Markdown rendering of `description`
      */
    def descriptionHtml: SelectionBuilder[Snippet, Option[String]] =
      Field("descriptionHtml", OptionOf(Scalar()))

    /**
      * All discussions on this noteable
      */
    def discussions[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[DiscussionConnection, A]
    ): SelectionBuilder[Snippet, A] =
      Field(
        "discussions",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * File Name of the snippet
      */
    def fileName: SelectionBuilder[Snippet, Option[String]] =
      Field("fileName", OptionOf(Scalar()))

    /**
      * Id of the snippet
      */
    def id: SelectionBuilder[Snippet, String] = Field("id", Scalar())

    /**
      * All notes on this noteable
      */
    def notes[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[NoteConnection, A]
    ): SelectionBuilder[Snippet, A] =
      Field(
        "notes",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * The project the snippet is associated with
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[Snippet, Option[A]] =
      Field("project", OptionOf(Obj(innerSelection)))

    /**
      * Raw URL of the snippet
      */
    def rawUrl: SelectionBuilder[Snippet, String] = Field("rawUrl", Scalar())

    /**
      * Title of the snippet
      */
    def title: SelectionBuilder[Snippet, String] = Field("title", Scalar())

    /**
      * Timestamp this snippet was updated
      */
    def updatedAt: SelectionBuilder[Snippet, Time] =
      Field("updatedAt", Scalar())

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[SnippetPermissions, A]
    ): SelectionBuilder[Snippet, A] =
      Field("userPermissions", Obj(innerSelection))

    /**
      * Visibility Level of the snippet
      */
    def visibilityLevel: SelectionBuilder[Snippet, VisibilityLevelsEnum] =
      Field("visibilityLevel", Scalar())

    /**
      * Web URL of the snippet
      */
    def webUrl: SelectionBuilder[Snippet, String] = Field("webUrl", Scalar())
  }

  type SnippetBlob
  object SnippetBlob {

    /**
      * Shows whether the blob is binary
      */
    def binary: SelectionBuilder[SnippetBlob, Boolean] =
      Field("binary", Scalar())

    /**
      * Blob mode
      */
    def mode: SelectionBuilder[SnippetBlob, Option[String]] =
      Field("mode", OptionOf(Scalar()))

    /**
      * Blob name
      */
    def name: SelectionBuilder[SnippetBlob, Option[String]] =
      Field("name", OptionOf(Scalar()))

    /**
      * Blob path
      */
    def path: SelectionBuilder[SnippetBlob, Option[String]] =
      Field("path", OptionOf(Scalar()))

    /**
      * Blob plain highlighted data
      */
    def plainData: SelectionBuilder[SnippetBlob, Option[String]] =
      Field("plainData", OptionOf(Scalar()))

    /**
      * Blob raw content endpoint path
      */
    def rawPath: SelectionBuilder[SnippetBlob, String] =
      Field("rawPath", Scalar())

    /**
      * Blob highlighted data
      */
    def richData: SelectionBuilder[SnippetBlob, Option[String]] =
      Field("richData", OptionOf(Scalar()))

    /**
      * Blob content rich viewer
      */
    def richViewer[A](
        innerSelection: SelectionBuilder[SnippetBlobViewer, A]
    ): SelectionBuilder[SnippetBlob, Option[A]] =
      Field("richViewer", OptionOf(Obj(innerSelection)))

    /**
      * Blob content simple viewer
      */
    def simpleViewer[A](
        innerSelection: SelectionBuilder[SnippetBlobViewer, A]
    ): SelectionBuilder[SnippetBlob, A] =
      Field("simpleViewer", Obj(innerSelection))

    /**
      * Blob size
      */
    def size: SelectionBuilder[SnippetBlob, Int] = Field("size", Scalar())
  }

  type SnippetBlobViewer
  object SnippetBlobViewer {

    /**
      * Shows whether the blob should be displayed collapsed
      */
    def collapsed: SelectionBuilder[SnippetBlobViewer, Boolean] =
      Field("collapsed", Scalar())

    /**
      * Content file type
      */
    def fileType: SelectionBuilder[SnippetBlobViewer, String] =
      Field("fileType", Scalar())

    /**
      * Shows whether the blob content is loaded async
      */
    def loadAsync: SelectionBuilder[SnippetBlobViewer, Boolean] =
      Field("loadAsync", Scalar())

    /**
      * Loading partial name
      */
    def loadingPartialName: SelectionBuilder[SnippetBlobViewer, String] =
      Field("loadingPartialName", Scalar())

    /**
      * Error rendering the blob content
      */
    def renderError: SelectionBuilder[SnippetBlobViewer, Option[String]] =
      Field("renderError", OptionOf(Scalar()))

    /**
      * Shows whether the blob too large to be displayed
      */
    def tooLarge: SelectionBuilder[SnippetBlobViewer, Boolean] =
      Field("tooLarge", Scalar())

    /**
      * Type of blob viewer
      */
    def `type`: SelectionBuilder[SnippetBlobViewer, BlobViewersType] =
      Field("type", Scalar())
  }

  type SnippetConnection
  object SnippetConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[SnippetEdge, A]
    ): SelectionBuilder[SnippetConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Snippet, A]
    ): SelectionBuilder[SnippetConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SnippetConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type SnippetEdge
  object SnippetEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[SnippetEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Snippet, A]
    ): SelectionBuilder[SnippetEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type SnippetPermissions
  object SnippetPermissions {

    /**
      * Indicates the user can perform `admin_snippet` on this resource
      */
    def adminSnippet: SelectionBuilder[SnippetPermissions, Boolean] =
      Field("adminSnippet", Scalar())

    /**
      * Indicates the user can perform `award_emoji` on this resource
      */
    def awardEmoji: SelectionBuilder[SnippetPermissions, Boolean] =
      Field("awardEmoji", Scalar())

    /**
      * Indicates the user can perform `create_note` on this resource
      */
    def createNote: SelectionBuilder[SnippetPermissions, Boolean] =
      Field("createNote", Scalar())

    /**
      * Indicates the user can perform `read_snippet` on this resource
      */
    def readSnippet: SelectionBuilder[SnippetPermissions, Boolean] =
      Field("readSnippet", Scalar())

    /**
      * Indicates the user can perform `report_snippet` on this resource
      */
    def reportSnippet: SelectionBuilder[SnippetPermissions, Boolean] =
      Field("reportSnippet", Scalar())

    /**
      * Indicates the user can perform `update_snippet` on this resource
      */
    def updateSnippet: SelectionBuilder[SnippetPermissions, Boolean] =
      Field("updateSnippet", Scalar())
  }

  type Submodule
  object Submodule {

    /**
      * Flat path of the entry
      */
    def flatPath: SelectionBuilder[Submodule, String] =
      Field("flatPath", Scalar())

    /**
      * ID of the entry
      */
    def id: SelectionBuilder[Submodule, String] = Field("id", Scalar())

    /**
      * Name of the entry
      */
    def name: SelectionBuilder[Submodule, String] = Field("name", Scalar())

    /**
      * Path of the entry
      */
    def path: SelectionBuilder[Submodule, String] = Field("path", Scalar())

    /**
      * Last commit sha for the entry
      */
    def sha: SelectionBuilder[Submodule, String] = Field("sha", Scalar())

    /**
      * Tree URL for the sub-module
      */
    def treeUrl: SelectionBuilder[Submodule, Option[String]] =
      Field("treeUrl", OptionOf(Scalar()))

    /**
      * Type of tree entry
      */
    def `type`: SelectionBuilder[Submodule, EntryType] = Field("type", Scalar())

    /**
      * Web URL for the sub-module
      */
    def webUrl: SelectionBuilder[Submodule, Option[String]] =
      Field("webUrl", OptionOf(Scalar()))
  }

  type SubmoduleConnection
  object SubmoduleConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[SubmoduleEdge, A]
    ): SelectionBuilder[SubmoduleConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Submodule, A]
    ): SelectionBuilder[SubmoduleConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[SubmoduleConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type SubmoduleEdge
  object SubmoduleEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[SubmoduleEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Submodule, A]
    ): SelectionBuilder[SubmoduleEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type TaskCompletionStatus
  object TaskCompletionStatus {

    /**
      * Number of completed tasks
      */
    def completedCount: SelectionBuilder[TaskCompletionStatus, Int] =
      Field("completedCount", Scalar())

    /**
      * Number of total tasks
      */
    def count: SelectionBuilder[TaskCompletionStatus, Int] =
      Field("count", Scalar())
  }

  type Timelog
  object Timelog {

    /**
      * The date when the time tracked was spent at
      */
    def date: SelectionBuilder[Timelog, Time] = Field("date", Scalar())

    /**
      * The issue that logged time was added to
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[Timelog, Option[A]] =
      Field("issue", OptionOf(Obj(innerSelection)))

    /**
      * The time spent displayed in seconds
      */
    def timeSpent: SelectionBuilder[Timelog, Int] = Field("timeSpent", Scalar())

    /**
      * The user that logged the time
      */
    def user[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Timelog, A] = Field("user", Obj(innerSelection))
  }

  type TimelogConnection
  object TimelogConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[TimelogEdge, A]
    ): SelectionBuilder[TimelogConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Timelog, A]
    ): SelectionBuilder[TimelogConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[TimelogConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type TimelogEdge
  object TimelogEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[TimelogEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Timelog, A]
    ): SelectionBuilder[TimelogEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type Todo
  object Todo {

    /**
      * Action of the todo
      */
    def action: SelectionBuilder[Todo, TodoActionEnum] =
      Field("action", Scalar())

    /**
      * The owner of this todo
      */
    def author[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[Todo, A] = Field("author", Obj(innerSelection))

    /**
      * Body of the todo
      */
    def body: SelectionBuilder[Todo, String] = Field("body", Scalar())

    /**
      * Timestamp this todo was created
      */
    def createdAt: SelectionBuilder[Todo, Time] = Field("createdAt", Scalar())

    /**
      * Group this todo is associated with
      */
    def group[A](
        innerSelection: SelectionBuilder[Group, A]
    ): SelectionBuilder[Todo, Option[A]] =
      Field("group", OptionOf(Obj(innerSelection)))

    /**
      * Id of the todo
      */
    def id: SelectionBuilder[Todo, String] = Field("id", Scalar())

    /**
      * The project this todo is associated with
      */
    def project[A](
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[Todo, Option[A]] =
      Field("project", OptionOf(Obj(innerSelection)))

    /**
      * State of the todo
      */
    def state: SelectionBuilder[Todo, TodoStateEnum] = Field("state", Scalar())

    /**
      * Target type of the todo
      */
    def targetType: SelectionBuilder[Todo, TodoTargetEnum] =
      Field("targetType", Scalar())
  }

  type TodoConnection
  object TodoConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[TodoEdge, A]
    ): SelectionBuilder[TodoConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[Todo, A]
    ): SelectionBuilder[TodoConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[TodoConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type TodoEdge
  object TodoEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[TodoEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[Todo, A]
    ): SelectionBuilder[TodoEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type TodoMarkDonePayload
  object TodoMarkDonePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[TodoMarkDonePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[TodoMarkDonePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The requested todo
      */
    def todo[A](
        innerSelection: SelectionBuilder[Todo, A]
    ): SelectionBuilder[TodoMarkDonePayload, A] =
      Field("todo", Obj(innerSelection))
  }

  type TodoRestoreManyPayload
  object TodoRestoreManyPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[TodoRestoreManyPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[TodoRestoreManyPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The ids of the updated todo items
      */
    def updatedIds: SelectionBuilder[TodoRestoreManyPayload, List[String]] =
      Field("updatedIds", ListOf(Scalar()))
  }

  type TodoRestorePayload
  object TodoRestorePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[TodoRestorePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[TodoRestorePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The requested todo
      */
    def todo[A](
        innerSelection: SelectionBuilder[Todo, A]
    ): SelectionBuilder[TodoRestorePayload, A] =
      Field("todo", Obj(innerSelection))
  }

  type TodosMarkAllDonePayload
  object TodosMarkAllDonePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[TodosMarkAllDonePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[TodosMarkAllDonePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * Ids of the updated todos
      */
    def updatedIds: SelectionBuilder[TodosMarkAllDonePayload, List[String]] =
      Field("updatedIds", ListOf(Scalar()))
  }

  type ToggleAwardEmojiPayload
  object ToggleAwardEmojiPayload {

    /**
      * The award emoji after mutation
      */
    def awardEmoji[A](
        innerSelection: SelectionBuilder[AwardEmoji, A]
    ): SelectionBuilder[ToggleAwardEmojiPayload, Option[A]] =
      Field("awardEmoji", OptionOf(Obj(innerSelection)))

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[ToggleAwardEmojiPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[ToggleAwardEmojiPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * Indicates the status of the emoji. True if the toggle awarded the emoji, and false if the toggle removed the emoji.
      */
    def toggledOn: SelectionBuilder[ToggleAwardEmojiPayload, Boolean] =
      Field("toggledOn", Scalar())
  }

  type Tree
  object Tree {

    /**
      * Blobs of the tree
      */
    def blobs[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[BlobConnection, A]
    ): SelectionBuilder[Tree, A] =
      Field(
        "blobs",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Last commit for the tree
      */
    def lastCommit[A](
        innerSelection: SelectionBuilder[Commit, A]
    ): SelectionBuilder[Tree, Option[A]] =
      Field("lastCommit", OptionOf(Obj(innerSelection)))

    /**
      * Sub-modules of the tree
      */
    def submodules[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[SubmoduleConnection, A]
    ): SelectionBuilder[Tree, A] =
      Field(
        "submodules",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )

    /**
      * Trees of the tree
      */
    def trees[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        last: Option[Int] = None
    )(
        innerSelection: SelectionBuilder[TreeEntryConnection, A]
    ): SelectionBuilder[Tree, A] =
      Field(
        "trees",
        Obj(innerSelection),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("last", last)
        )
      )
  }

  type TreeEntry
  object TreeEntry {

    /**
      * Flat path of the entry
      */
    def flatPath: SelectionBuilder[TreeEntry, String] =
      Field("flatPath", Scalar())

    /**
      * ID of the entry
      */
    def id: SelectionBuilder[TreeEntry, String] = Field("id", Scalar())

    /**
      * Name of the entry
      */
    def name: SelectionBuilder[TreeEntry, String] = Field("name", Scalar())

    /**
      * Path of the entry
      */
    def path: SelectionBuilder[TreeEntry, String] = Field("path", Scalar())

    /**
      * Last commit sha for the entry
      */
    def sha: SelectionBuilder[TreeEntry, String] = Field("sha", Scalar())

    /**
      * Type of tree entry
      */
    def `type`: SelectionBuilder[TreeEntry, EntryType] = Field("type", Scalar())

    /**
      * Web URL for the tree entry (directory)
      */
    def webUrl: SelectionBuilder[TreeEntry, Option[String]] =
      Field("webUrl", OptionOf(Scalar()))
  }

  type TreeEntryConnection
  object TreeEntryConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[TreeEntryEdge, A]
    ): SelectionBuilder[TreeEntryConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[TreeEntry, A]
    ): SelectionBuilder[TreeEntryConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[TreeEntryConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type TreeEntryEdge
  object TreeEntryEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[TreeEntryEdge, String] =
      Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[TreeEntry, A]
    ): SelectionBuilder[TreeEntryEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type UpdateEpicPayload
  object UpdateEpicPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[UpdateEpicPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * The epic after mutation
      */
    def epic[A](
        innerSelection: SelectionBuilder[Epic, A]
    ): SelectionBuilder[UpdateEpicPayload, Option[A]] =
      Field("epic", OptionOf(Obj(innerSelection)))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[UpdateEpicPayload, List[String]] =
      Field("errors", ListOf(Scalar()))
  }

  type UpdateImageDiffNotePayload
  object UpdateImageDiffNotePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[UpdateImageDiffNotePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[UpdateImageDiffNotePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The note after mutation
      */
    def note[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[UpdateImageDiffNotePayload, Option[A]] =
      Field("note", OptionOf(Obj(innerSelection)))
  }

  type UpdateIssuePayload
  object UpdateIssuePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[UpdateIssuePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[UpdateIssuePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The issue after mutation
      */
    def issue[A](
        innerSelection: SelectionBuilder[Issue, A]
    ): SelectionBuilder[UpdateIssuePayload, Option[A]] =
      Field("issue", OptionOf(Obj(innerSelection)))
  }

  type UpdateNotePayload
  object UpdateNotePayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId: SelectionBuilder[UpdateNotePayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[UpdateNotePayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The note after mutation
      */
    def note[A](
        innerSelection: SelectionBuilder[Note, A]
    ): SelectionBuilder[UpdateNotePayload, Option[A]] =
      Field("note", OptionOf(Obj(innerSelection)))
  }

  type UpdateSnippetPayload
  object UpdateSnippetPayload {

    /**
      * A unique identifier for the client performing the mutation.
      */
    def clientMutationId
        : SelectionBuilder[UpdateSnippetPayload, Option[String]] =
      Field("clientMutationId", OptionOf(Scalar()))

    /**
      * Reasons why the mutation failed.
      */
    def errors: SelectionBuilder[UpdateSnippetPayload, List[String]] =
      Field("errors", ListOf(Scalar()))

    /**
      * The snippet after mutation
      */
    def snippet[A](
        innerSelection: SelectionBuilder[Snippet, A]
    ): SelectionBuilder[UpdateSnippetPayload, Option[A]] =
      Field("snippet", OptionOf(Obj(innerSelection)))
  }

  type User
  object User {

    /**
      * URL of the user's avatar
      */
    def avatarUrl: SelectionBuilder[User, Option[String]] =
      Field("avatarUrl", OptionOf(Scalar()))

    /**
      * Human-readable name of the user
      */
    def name: SelectionBuilder[User, String] = Field("name", Scalar())

    /**
      * Snippets authored by the user
      */
    def snippets[A](
        after: Option[String] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        ids: Option[List[String]] = None,
        last: Option[Int] = None,
        `type`: Option[TypeEnum] = None,
        visibility: Option[VisibilityScopesEnum] = None
    )(
        innerSelection: SelectionBuilder[SnippetConnection, A]
    ): SelectionBuilder[User, Option[A]] =
      Field(
        "snippets",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("before", before),
          Argument("first", first),
          Argument("ids", ids),
          Argument("last", last),
          Argument("type", `type`),
          Argument("visibility", visibility)
        )
      )

    /**
      * Todos of the user
      */
    def todos[A](
        action: Option[List[TodoActionEnum]] = None,
        after: Option[String] = None,
        authorId: Option[List[String]] = None,
        before: Option[String] = None,
        first: Option[Int] = None,
        groupId: Option[List[String]] = None,
        last: Option[Int] = None,
        projectId: Option[List[String]] = None,
        state: Option[List[TodoStateEnum]] = None,
        `type`: Option[List[TodoTargetEnum]] = None
    )(
        innerSelection: SelectionBuilder[TodoConnection, A]
    ): SelectionBuilder[User, A] =
      Field(
        "todos",
        Obj(innerSelection),
        arguments = List(
          Argument("action", action),
          Argument("after", after),
          Argument("authorId", authorId),
          Argument("before", before),
          Argument("first", first),
          Argument("groupId", groupId),
          Argument("last", last),
          Argument("projectId", projectId),
          Argument("state", state),
          Argument("type", `type`)
        )
      )

    /**
      * Permissions for the current user on the resource
      */
    def userPermissions[A](
        innerSelection: SelectionBuilder[UserPermissions, A]
    ): SelectionBuilder[User, A] = Field("userPermissions", Obj(innerSelection))

    /**
      * Username of the user. Unique within this instance of GitLab
      */
    def username: SelectionBuilder[User, String] = Field("username", Scalar())

    /**
      * Web URL of the user
      */
    def webUrl: SelectionBuilder[User, String] = Field("webUrl", Scalar())
  }

  type UserConnection
  object UserConnection {

    /**
      * A list of edges.
      */
    def edges[A](
        innerSelection: SelectionBuilder[UserEdge, A]
    ): SelectionBuilder[UserConnection, Option[List[Option[A]]]] =
      Field("edges", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * A list of nodes.
      */
    def nodes[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[UserConnection, Option[List[Option[A]]]] =
      Field("nodes", OptionOf(ListOf(OptionOf(Obj(innerSelection)))))

    /**
      * Information to aid in pagination.
      */
    def pageInfo[A](
        innerSelection: SelectionBuilder[PageInfo, A]
    ): SelectionBuilder[UserConnection, A] =
      Field("pageInfo", Obj(innerSelection))
  }

  type UserEdge
  object UserEdge {

    /**
      * A cursor for use in pagination.
      */
    def cursor: SelectionBuilder[UserEdge, String] = Field("cursor", Scalar())

    /**
      * The item at the end of the edge.
      */
    def node[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[UserEdge, Option[A]] =
      Field("node", OptionOf(Obj(innerSelection)))
  }

  type UserPermissions
  object UserPermissions {

    /**
      * Indicates the user can perform `create_snippet` on this resource
      */
    def createSnippet: SelectionBuilder[UserPermissions, Boolean] =
      Field("createSnippet", Scalar())
  }

  case class AddAwardEmojiInput(
      awardableId: String,
      clientMutationId: Option[String] = None,
      name: String
  )
  object AddAwardEmojiInput {
    implicit val encoder: ArgEncoder[AddAwardEmojiInput] =
      new ArgEncoder[AddAwardEmojiInput] {
        override def encode(value: AddAwardEmojiInput): Value =
          ObjectValue(
            List(
              "awardableId" -> implicitly[ArgEncoder[String]]
                .encode(value.awardableId),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name)
            )
          )
        override def typeName: String = "AddAwardEmojiInput"
      }
  }
  case class AdminSidekiqQueuesDeleteJobsInput(
      callerId: Option[String] = None,
      clientMutationId: Option[String] = None,
      project: Option[String] = None,
      queueName: String,
      rootNamespace: Option[String] = None,
      subscriptionPlan: Option[String] = None,
      user: Option[String] = None
  )
  object AdminSidekiqQueuesDeleteJobsInput {
    implicit val encoder: ArgEncoder[AdminSidekiqQueuesDeleteJobsInput] =
      new ArgEncoder[AdminSidekiqQueuesDeleteJobsInput] {
        override def encode(value: AdminSidekiqQueuesDeleteJobsInput): Value =
          ObjectValue(
            List(
              "callerId" -> value.callerId.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "project" -> value.project.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "queueName" -> implicitly[ArgEncoder[String]]
                .encode(value.queueName),
              "rootNamespace" -> value.rootNamespace.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "subscriptionPlan" -> value.subscriptionPlan.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "user" -> value.user.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "AdminSidekiqQueuesDeleteJobsInput"
      }
  }
  case class CreateDiffNoteInput(
      body: String,
      clientMutationId: Option[String] = None,
      noteableId: String,
      position: DiffPositionInput
  )
  object CreateDiffNoteInput {
    implicit val encoder: ArgEncoder[CreateDiffNoteInput] =
      new ArgEncoder[CreateDiffNoteInput] {
        override def encode(value: CreateDiffNoteInput): Value =
          ObjectValue(
            List(
              "body" -> implicitly[ArgEncoder[String]].encode(value.body),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "noteableId" -> implicitly[ArgEncoder[String]]
                .encode(value.noteableId),
              "position" -> implicitly[ArgEncoder[DiffPositionInput]]
                .encode(value.position)
            )
          )
        override def typeName: String = "CreateDiffNoteInput"
      }
  }
  case class CreateEpicInput(
      addLabelIds: Option[List[String]] = None,
      clientMutationId: Option[String] = None,
      description: Option[String] = None,
      dueDateFixed: Option[String] = None,
      dueDateIsFixed: Option[Boolean] = None,
      groupPath: String,
      removeLabelIds: Option[List[String]] = None,
      startDateFixed: Option[String] = None,
      startDateIsFixed: Option[Boolean] = None,
      title: Option[String] = None
  )
  object CreateEpicInput {
    implicit val encoder: ArgEncoder[CreateEpicInput] =
      new ArgEncoder[CreateEpicInput] {
        override def encode(value: CreateEpicInput): Value =
          ObjectValue(
            List(
              "addLabelIds" -> value.addLabelIds.fold(NullValue: Value)(value =>
                ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "description" -> value.description.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "dueDateFixed" -> value.dueDateFixed.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "dueDateIsFixed" -> value.dueDateIsFixed.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "groupPath" -> implicitly[ArgEncoder[String]]
                .encode(value.groupPath),
              "removeLabelIds" -> value.removeLabelIds.fold(NullValue: Value)(
                value =>
                  ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "startDateFixed" -> value.startDateFixed.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "startDateIsFixed" -> value.startDateIsFixed.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "title" -> value.title.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "CreateEpicInput"
      }
  }
  case class CreateImageDiffNoteInput(
      body: String,
      clientMutationId: Option[String] = None,
      noteableId: String,
      position: DiffImagePositionInput
  )
  object CreateImageDiffNoteInput {
    implicit val encoder: ArgEncoder[CreateImageDiffNoteInput] =
      new ArgEncoder[CreateImageDiffNoteInput] {
        override def encode(value: CreateImageDiffNoteInput): Value =
          ObjectValue(
            List(
              "body" -> implicitly[ArgEncoder[String]].encode(value.body),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "noteableId" -> implicitly[ArgEncoder[String]]
                .encode(value.noteableId),
              "position" -> implicitly[ArgEncoder[DiffImagePositionInput]]
                .encode(value.position)
            )
          )
        override def typeName: String = "CreateImageDiffNoteInput"
      }
  }
  case class CreateNoteInput(
      body: String,
      clientMutationId: Option[String] = None,
      discussionId: Option[String] = None,
      noteableId: String
  )
  object CreateNoteInput {
    implicit val encoder: ArgEncoder[CreateNoteInput] =
      new ArgEncoder[CreateNoteInput] {
        override def encode(value: CreateNoteInput): Value =
          ObjectValue(
            List(
              "body" -> implicitly[ArgEncoder[String]].encode(value.body),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "discussionId" -> value.discussionId.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "noteableId" -> implicitly[ArgEncoder[String]]
                .encode(value.noteableId)
            )
          )
        override def typeName: String = "CreateNoteInput"
      }
  }
  case class CreateSnippetInput(
      clientMutationId: Option[String] = None,
      content: String,
      description: Option[String] = None,
      fileName: Option[String] = None,
      projectPath: Option[String] = None,
      title: String,
      visibilityLevel: VisibilityLevelsEnum
  )
  object CreateSnippetInput {
    implicit val encoder: ArgEncoder[CreateSnippetInput] =
      new ArgEncoder[CreateSnippetInput] {
        override def encode(value: CreateSnippetInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "content" -> implicitly[ArgEncoder[String]].encode(value.content),
              "description" -> value.description.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "fileName" -> value.fileName.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "projectPath" -> value.projectPath.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "title" -> implicitly[ArgEncoder[String]].encode(value.title),
              "visibilityLevel" -> implicitly[ArgEncoder[VisibilityLevelsEnum]]
                .encode(value.visibilityLevel)
            )
          )
        override def typeName: String = "CreateSnippetInput"
      }
  }
  case class DesignManagementDeleteInput(
      clientMutationId: Option[String] = None,
      filenames: List[String] = Nil,
      iid: String,
      projectPath: String
  )
  object DesignManagementDeleteInput {
    implicit val encoder: ArgEncoder[DesignManagementDeleteInput] =
      new ArgEncoder[DesignManagementDeleteInput] {
        override def encode(value: DesignManagementDeleteInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "filenames" -> ListValue(
                value.filenames.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "DesignManagementDeleteInput"
      }
  }
  case class DesignManagementUploadInput(
      clientMutationId: Option[String] = None,
      files: List[Upload] = Nil,
      iid: String,
      projectPath: String
  )
  object DesignManagementUploadInput {
    implicit val encoder: ArgEncoder[DesignManagementUploadInput] =
      new ArgEncoder[DesignManagementUploadInput] {
        override def encode(value: DesignManagementUploadInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "files" -> ListValue(
                value.files.map(value =>
                  implicitly[ArgEncoder[Upload]].encode(value)
                )
              ),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "DesignManagementUploadInput"
      }
  }
  case class DestroyNoteInput(
      clientMutationId: Option[String] = None,
      id: String
  )
  object DestroyNoteInput {
    implicit val encoder: ArgEncoder[DestroyNoteInput] =
      new ArgEncoder[DestroyNoteInput] {
        override def encode(value: DestroyNoteInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id)
            )
          )
        override def typeName: String = "DestroyNoteInput"
      }
  }
  case class DestroySnippetInput(
      clientMutationId: Option[String] = None,
      id: String
  )
  object DestroySnippetInput {
    implicit val encoder: ArgEncoder[DestroySnippetInput] =
      new ArgEncoder[DestroySnippetInput] {
        override def encode(value: DestroySnippetInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id)
            )
          )
        override def typeName: String = "DestroySnippetInput"
      }
  }
  case class DiffImagePositionInput(
      baseSha: Option[String] = None,
      headSha: String,
      height: Int,
      paths: DiffPathsInput,
      startSha: String,
      width: Int,
      x: Int,
      y: Int
  )
  object DiffImagePositionInput {
    implicit val encoder: ArgEncoder[DiffImagePositionInput] =
      new ArgEncoder[DiffImagePositionInput] {
        override def encode(value: DiffImagePositionInput): Value =
          ObjectValue(
            List(
              "baseSha" -> value.baseSha.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "headSha" -> implicitly[ArgEncoder[String]].encode(value.headSha),
              "height" -> implicitly[ArgEncoder[Int]].encode(value.height),
              "paths" -> implicitly[ArgEncoder[DiffPathsInput]]
                .encode(value.paths),
              "startSha" -> implicitly[ArgEncoder[String]]
                .encode(value.startSha),
              "width" -> implicitly[ArgEncoder[Int]].encode(value.width),
              "x" -> implicitly[ArgEncoder[Int]].encode(value.x),
              "y" -> implicitly[ArgEncoder[Int]].encode(value.y)
            )
          )
        override def typeName: String = "DiffImagePositionInput"
      }
  }
  case class DiffPathsInput(
      newPath: Option[String] = None,
      oldPath: Option[String] = None
  )
  object DiffPathsInput {
    implicit val encoder: ArgEncoder[DiffPathsInput] =
      new ArgEncoder[DiffPathsInput] {
        override def encode(value: DiffPathsInput): Value =
          ObjectValue(
            List(
              "newPath" -> value.newPath.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "oldPath" -> value.oldPath.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "DiffPathsInput"
      }
  }
  case class DiffPositionInput(
      baseSha: Option[String] = None,
      headSha: String,
      newLine: Int,
      oldLine: Option[Int] = None,
      paths: DiffPathsInput,
      startSha: String
  )
  object DiffPositionInput {
    implicit val encoder: ArgEncoder[DiffPositionInput] =
      new ArgEncoder[DiffPositionInput] {
        override def encode(value: DiffPositionInput): Value =
          ObjectValue(
            List(
              "baseSha" -> value.baseSha.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "headSha" -> implicitly[ArgEncoder[String]].encode(value.headSha),
              "newLine" -> implicitly[ArgEncoder[Int]].encode(value.newLine),
              "oldLine" -> value.oldLine.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "paths" -> implicitly[ArgEncoder[DiffPathsInput]]
                .encode(value.paths),
              "startSha" -> implicitly[ArgEncoder[String]]
                .encode(value.startSha)
            )
          )
        override def typeName: String = "DiffPositionInput"
      }
  }
  case class EpicAddIssueInput(
      clientMutationId: Option[String] = None,
      groupPath: String,
      iid: String,
      issueIid: String,
      projectPath: String
  )
  object EpicAddIssueInput {
    implicit val encoder: ArgEncoder[EpicAddIssueInput] =
      new ArgEncoder[EpicAddIssueInput] {
        override def encode(value: EpicAddIssueInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "groupPath" -> implicitly[ArgEncoder[String]]
                .encode(value.groupPath),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "issueIid" -> implicitly[ArgEncoder[String]]
                .encode(value.issueIid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "EpicAddIssueInput"
      }
  }
  case class EpicSetSubscriptionInput(
      clientMutationId: Option[String] = None,
      groupPath: String,
      iid: String,
      subscribedState: Boolean
  )
  object EpicSetSubscriptionInput {
    implicit val encoder: ArgEncoder[EpicSetSubscriptionInput] =
      new ArgEncoder[EpicSetSubscriptionInput] {
        override def encode(value: EpicSetSubscriptionInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "groupPath" -> implicitly[ArgEncoder[String]]
                .encode(value.groupPath),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "subscribedState" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.subscribedState)
            )
          )
        override def typeName: String = "EpicSetSubscriptionInput"
      }
  }
  case class EpicTreeNodeFieldsInputType(
      adjacentReferenceId: String,
      id: String,
      relativePosition: MoveType
  )
  object EpicTreeNodeFieldsInputType {
    implicit val encoder: ArgEncoder[EpicTreeNodeFieldsInputType] =
      new ArgEncoder[EpicTreeNodeFieldsInputType] {
        override def encode(value: EpicTreeNodeFieldsInputType): Value =
          ObjectValue(
            List(
              "adjacentReferenceId" -> implicitly[ArgEncoder[String]]
                .encode(value.adjacentReferenceId),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "relativePosition" -> implicitly[ArgEncoder[MoveType]]
                .encode(value.relativePosition)
            )
          )
        override def typeName: String = "EpicTreeNodeFieldsInputType"
      }
  }
  case class EpicTreeReorderInput(
      baseEpicId: String,
      clientMutationId: Option[String] = None,
      moved: EpicTreeNodeFieldsInputType
  )
  object EpicTreeReorderInput {
    implicit val encoder: ArgEncoder[EpicTreeReorderInput] =
      new ArgEncoder[EpicTreeReorderInput] {
        override def encode(value: EpicTreeReorderInput): Value =
          ObjectValue(
            List(
              "baseEpicId" -> implicitly[ArgEncoder[String]]
                .encode(value.baseEpicId),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "moved" -> implicitly[ArgEncoder[EpicTreeNodeFieldsInputType]]
                .encode(value.moved)
            )
          )
        override def typeName: String = "EpicTreeReorderInput"
      }
  }
  case class IssueSetConfidentialInput(
      clientMutationId: Option[String] = None,
      confidential: Boolean,
      iid: String,
      projectPath: String
  )
  object IssueSetConfidentialInput {
    implicit val encoder: ArgEncoder[IssueSetConfidentialInput] =
      new ArgEncoder[IssueSetConfidentialInput] {
        override def encode(value: IssueSetConfidentialInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "confidential" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.confidential),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "IssueSetConfidentialInput"
      }
  }
  case class IssueSetDueDateInput(
      clientMutationId: Option[String] = None,
      dueDate: Time,
      iid: String,
      projectPath: String
  )
  object IssueSetDueDateInput {
    implicit val encoder: ArgEncoder[IssueSetDueDateInput] =
      new ArgEncoder[IssueSetDueDateInput] {
        override def encode(value: IssueSetDueDateInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "dueDate" -> implicitly[ArgEncoder[Time]].encode(value.dueDate),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "IssueSetDueDateInput"
      }
  }
  case class IssueSetWeightInput(
      clientMutationId: Option[String] = None,
      iid: String,
      projectPath: String,
      weight: Int
  )
  object IssueSetWeightInput {
    implicit val encoder: ArgEncoder[IssueSetWeightInput] =
      new ArgEncoder[IssueSetWeightInput] {
        override def encode(value: IssueSetWeightInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath),
              "weight" -> implicitly[ArgEncoder[Int]].encode(value.weight)
            )
          )
        override def typeName: String = "IssueSetWeightInput"
      }
  }
  case class MarkAsSpamSnippetInput(
      clientMutationId: Option[String] = None,
      id: String
  )
  object MarkAsSpamSnippetInput {
    implicit val encoder: ArgEncoder[MarkAsSpamSnippetInput] =
      new ArgEncoder[MarkAsSpamSnippetInput] {
        override def encode(value: MarkAsSpamSnippetInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id)
            )
          )
        override def typeName: String = "MarkAsSpamSnippetInput"
      }
  }
  case class MergeRequestSetAssigneesInput(
      assigneeUsernames: List[String] = Nil,
      clientMutationId: Option[String] = None,
      iid: String,
      operationMode: Option[MutationOperationMode] = None,
      projectPath: String
  )
  object MergeRequestSetAssigneesInput {
    implicit val encoder: ArgEncoder[MergeRequestSetAssigneesInput] =
      new ArgEncoder[MergeRequestSetAssigneesInput] {
        override def encode(value: MergeRequestSetAssigneesInput): Value =
          ObjectValue(
            List(
              "assigneeUsernames" -> ListValue(
                value.assigneeUsernames.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "operationMode" -> value.operationMode.fold(NullValue: Value)(
                value =>
                  implicitly[ArgEncoder[MutationOperationMode]].encode(value)
              ),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "MergeRequestSetAssigneesInput"
      }
  }
  case class MergeRequestSetLabelsInput(
      clientMutationId: Option[String] = None,
      iid: String,
      labelIds: List[String] = Nil,
      operationMode: Option[MutationOperationMode] = None,
      projectPath: String
  )
  object MergeRequestSetLabelsInput {
    implicit val encoder: ArgEncoder[MergeRequestSetLabelsInput] =
      new ArgEncoder[MergeRequestSetLabelsInput] {
        override def encode(value: MergeRequestSetLabelsInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "labelIds" -> ListValue(
                value.labelIds.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              ),
              "operationMode" -> value.operationMode.fold(NullValue: Value)(
                value =>
                  implicitly[ArgEncoder[MutationOperationMode]].encode(value)
              ),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "MergeRequestSetLabelsInput"
      }
  }
  case class MergeRequestSetLockedInput(
      clientMutationId: Option[String] = None,
      iid: String,
      locked: Boolean,
      projectPath: String
  )
  object MergeRequestSetLockedInput {
    implicit val encoder: ArgEncoder[MergeRequestSetLockedInput] =
      new ArgEncoder[MergeRequestSetLockedInput] {
        override def encode(value: MergeRequestSetLockedInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "locked" -> implicitly[ArgEncoder[Boolean]].encode(value.locked),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "MergeRequestSetLockedInput"
      }
  }
  case class MergeRequestSetMilestoneInput(
      clientMutationId: Option[String] = None,
      iid: String,
      milestoneId: Option[String] = None,
      projectPath: String
  )
  object MergeRequestSetMilestoneInput {
    implicit val encoder: ArgEncoder[MergeRequestSetMilestoneInput] =
      new ArgEncoder[MergeRequestSetMilestoneInput] {
        override def encode(value: MergeRequestSetMilestoneInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "milestoneId" -> value.milestoneId.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath)
            )
          )
        override def typeName: String = "MergeRequestSetMilestoneInput"
      }
  }
  case class MergeRequestSetSubscriptionInput(
      clientMutationId: Option[String] = None,
      iid: String,
      projectPath: String,
      subscribedState: Boolean
  )
  object MergeRequestSetSubscriptionInput {
    implicit val encoder: ArgEncoder[MergeRequestSetSubscriptionInput] =
      new ArgEncoder[MergeRequestSetSubscriptionInput] {
        override def encode(value: MergeRequestSetSubscriptionInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath),
              "subscribedState" -> implicitly[ArgEncoder[Boolean]]
                .encode(value.subscribedState)
            )
          )
        override def typeName: String = "MergeRequestSetSubscriptionInput"
      }
  }
  case class MergeRequestSetWipInput(
      clientMutationId: Option[String] = None,
      iid: String,
      projectPath: String,
      wip: Boolean
  )
  object MergeRequestSetWipInput {
    implicit val encoder: ArgEncoder[MergeRequestSetWipInput] =
      new ArgEncoder[MergeRequestSetWipInput] {
        override def encode(value: MergeRequestSetWipInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath),
              "wip" -> implicitly[ArgEncoder[Boolean]].encode(value.wip)
            )
          )
        override def typeName: String = "MergeRequestSetWipInput"
      }
  }
  case class RemoveAwardEmojiInput(
      awardableId: String,
      clientMutationId: Option[String] = None,
      name: String
  )
  object RemoveAwardEmojiInput {
    implicit val encoder: ArgEncoder[RemoveAwardEmojiInput] =
      new ArgEncoder[RemoveAwardEmojiInput] {
        override def encode(value: RemoveAwardEmojiInput): Value =
          ObjectValue(
            List(
              "awardableId" -> implicitly[ArgEncoder[String]]
                .encode(value.awardableId),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name)
            )
          )
        override def typeName: String = "RemoveAwardEmojiInput"
      }
  }
  case class TodoMarkDoneInput(
      clientMutationId: Option[String] = None,
      id: String
  )
  object TodoMarkDoneInput {
    implicit val encoder: ArgEncoder[TodoMarkDoneInput] =
      new ArgEncoder[TodoMarkDoneInput] {
        override def encode(value: TodoMarkDoneInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id)
            )
          )
        override def typeName: String = "TodoMarkDoneInput"
      }
  }
  case class TodoRestoreInput(
      clientMutationId: Option[String] = None,
      id: String
  )
  object TodoRestoreInput {
    implicit val encoder: ArgEncoder[TodoRestoreInput] =
      new ArgEncoder[TodoRestoreInput] {
        override def encode(value: TodoRestoreInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id)
            )
          )
        override def typeName: String = "TodoRestoreInput"
      }
  }
  case class TodoRestoreManyInput(
      clientMutationId: Option[String] = None,
      ids: List[String] = Nil
  )
  object TodoRestoreManyInput {
    implicit val encoder: ArgEncoder[TodoRestoreManyInput] =
      new ArgEncoder[TodoRestoreManyInput] {
        override def encode(value: TodoRestoreManyInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "ids" -> ListValue(
                value.ids.map(value =>
                  implicitly[ArgEncoder[String]].encode(value)
                )
              )
            )
          )
        override def typeName: String = "TodoRestoreManyInput"
      }
  }
  case class TodosMarkAllDoneInput(clientMutationId: Option[String] = None)
  object TodosMarkAllDoneInput {
    implicit val encoder: ArgEncoder[TodosMarkAllDoneInput] =
      new ArgEncoder[TodosMarkAllDoneInput] {
        override def encode(value: TodosMarkAllDoneInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value))
            )
          )
        override def typeName: String = "TodosMarkAllDoneInput"
      }
  }
  case class ToggleAwardEmojiInput(
      awardableId: String,
      clientMutationId: Option[String] = None,
      name: String
  )
  object ToggleAwardEmojiInput {
    implicit val encoder: ArgEncoder[ToggleAwardEmojiInput] =
      new ArgEncoder[ToggleAwardEmojiInput] {
        override def encode(value: ToggleAwardEmojiInput): Value =
          ObjectValue(
            List(
              "awardableId" -> implicitly[ArgEncoder[String]]
                .encode(value.awardableId),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "name" -> implicitly[ArgEncoder[String]].encode(value.name)
            )
          )
        override def typeName: String = "ToggleAwardEmojiInput"
      }
  }
  case class UpdateDiffImagePositionInput(
      height: Option[Int] = None,
      width: Option[Int] = None,
      x: Option[Int] = None,
      y: Option[Int] = None
  )
  object UpdateDiffImagePositionInput {
    implicit val encoder: ArgEncoder[UpdateDiffImagePositionInput] =
      new ArgEncoder[UpdateDiffImagePositionInput] {
        override def encode(value: UpdateDiffImagePositionInput): Value =
          ObjectValue(
            List(
              "height" -> value.height.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "width" -> value.width.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "x" -> value.x.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              ),
              "y" -> value.y.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Int]].encode(value)
              )
            )
          )
        override def typeName: String = "UpdateDiffImagePositionInput"
      }
  }
  case class UpdateEpicInput(
      addLabelIds: Option[List[String]] = None,
      clientMutationId: Option[String] = None,
      description: Option[String] = None,
      dueDateFixed: Option[String] = None,
      dueDateIsFixed: Option[Boolean] = None,
      groupPath: String,
      iid: String,
      removeLabelIds: Option[List[String]] = None,
      startDateFixed: Option[String] = None,
      startDateIsFixed: Option[Boolean] = None,
      stateEvent: Option[EpicStateEvent] = None,
      title: Option[String] = None
  )
  object UpdateEpicInput {
    implicit val encoder: ArgEncoder[UpdateEpicInput] =
      new ArgEncoder[UpdateEpicInput] {
        override def encode(value: UpdateEpicInput): Value =
          ObjectValue(
            List(
              "addLabelIds" -> value.addLabelIds.fold(NullValue: Value)(value =>
                ListValue(
                  value.map(value =>
                    implicitly[ArgEncoder[String]].encode(value)
                  )
                )
              ),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "description" -> value.description.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "dueDateFixed" -> value.dueDateFixed.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "dueDateIsFixed" -> value.dueDateIsFixed.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "groupPath" -> implicitly[ArgEncoder[String]]
                .encode(value.groupPath),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "removeLabelIds" -> value.removeLabelIds.fold(NullValue: Value)(
                value =>
                  ListValue(
                    value.map(value =>
                      implicitly[ArgEncoder[String]].encode(value)
                    )
                  )
              ),
              "startDateFixed" -> value.startDateFixed.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[String]].encode(value)
              ),
              "startDateIsFixed" -> value.startDateIsFixed.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[Boolean]].encode(value)),
              "stateEvent" -> value.stateEvent.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[EpicStateEvent]].encode(value)
              ),
              "title" -> value.title.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "UpdateEpicInput"
      }
  }
  case class UpdateImageDiffNoteInput(
      body: Option[String] = None,
      clientMutationId: Option[String] = None,
      id: String,
      position: Option[UpdateDiffImagePositionInput] = None
  )
  object UpdateImageDiffNoteInput {
    implicit val encoder: ArgEncoder[UpdateImageDiffNoteInput] =
      new ArgEncoder[UpdateImageDiffNoteInput] {
        override def encode(value: UpdateImageDiffNoteInput): Value =
          ObjectValue(
            List(
              "body" -> value.body.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "position" -> value.position.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[UpdateDiffImagePositionInput]]
                  .encode(value)
              )
            )
          )
        override def typeName: String = "UpdateImageDiffNoteInput"
      }
  }
  case class UpdateIssueInput(
      clientMutationId: Option[String] = None,
      confidential: Option[Boolean] = None,
      description: Option[String] = None,
      dueDate: Option[Time] = None,
      healthStatus: Option[HealthStatus] = None,
      iid: String,
      projectPath: String,
      title: Option[String] = None
  )
  object UpdateIssueInput {
    implicit val encoder: ArgEncoder[UpdateIssueInput] =
      new ArgEncoder[UpdateIssueInput] {
        override def encode(value: UpdateIssueInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "confidential" -> value.confidential.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[Boolean]].encode(value)
              ),
              "description" -> value.description.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "dueDate" -> value.dueDate.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[Time]].encode(value)
              ),
              "healthStatus" -> value.healthStatus.fold(NullValue: Value)(
                value => implicitly[ArgEncoder[HealthStatus]].encode(value)
              ),
              "iid" -> implicitly[ArgEncoder[String]].encode(value.iid),
              "projectPath" -> implicitly[ArgEncoder[String]]
                .encode(value.projectPath),
              "title" -> value.title.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
        override def typeName: String = "UpdateIssueInput"
      }
  }
  case class UpdateNoteInput(
      body: String,
      clientMutationId: Option[String] = None,
      id: String
  )
  object UpdateNoteInput {
    implicit val encoder: ArgEncoder[UpdateNoteInput] =
      new ArgEncoder[UpdateNoteInput] {
        override def encode(value: UpdateNoteInput): Value =
          ObjectValue(
            List(
              "body" -> implicitly[ArgEncoder[String]].encode(value.body),
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id)
            )
          )
        override def typeName: String = "UpdateNoteInput"
      }
  }
  case class UpdateSnippetInput(
      clientMutationId: Option[String] = None,
      content: Option[String] = None,
      description: Option[String] = None,
      fileName: Option[String] = None,
      id: String,
      title: Option[String] = None,
      visibilityLevel: Option[VisibilityLevelsEnum] = None
  )
  object UpdateSnippetInput {
    implicit val encoder: ArgEncoder[UpdateSnippetInput] =
      new ArgEncoder[UpdateSnippetInput] {
        override def encode(value: UpdateSnippetInput): Value =
          ObjectValue(
            List(
              "clientMutationId" -> value.clientMutationId.fold(
                NullValue: Value
              )(value => implicitly[ArgEncoder[String]].encode(value)),
              "content" -> value.content.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "description" -> value.description.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "fileName" -> value.fileName.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "id" -> implicitly[ArgEncoder[String]].encode(value.id),
              "title" -> value.title.fold(NullValue: Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "visibilityLevel" -> value.visibilityLevel.fold(NullValue: Value)(
                value =>
                  implicitly[ArgEncoder[VisibilityLevelsEnum]].encode(value)
              )
            )
          )
        override def typeName: String = "UpdateSnippetInput"
      }
  }
  type Query = RootQuery
  object Query {

    /**
      * Get information about current user
      */
    def currentUser[A](
        innerSelection: SelectionBuilder[User, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field("currentUser", OptionOf(Obj(innerSelection)))

    /**
      * Fields related to design management
      */
    def designManagement[A](
        innerSelection: SelectionBuilder[DesignManagement, A]
    ): SelectionBuilder[RootQuery, A] =
      Field("designManagement", Obj(innerSelection))

    /**
      * Text to echo back
      */
    def echo(text: String): SelectionBuilder[RootQuery, String] =
      Field("echo", Scalar(), arguments = List(Argument("text", text)))

    /**
      * Find a group
      */
    def group[A](fullPath: String)(
        innerSelection: SelectionBuilder[Group, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "group",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("fullPath", fullPath))
      )

    /**
      * Metadata about GitLab
      */
    def metadata[A](
        innerSelection: SelectionBuilder[Metadata, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field("metadata", OptionOf(Obj(innerSelection)))

    /**
      * Find a namespace
      */
    def namespace[A](fullPath: String)(
        innerSelection: SelectionBuilder[Namespace, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "namespace",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("fullPath", fullPath))
      )

    /**
      * Find a project
      */
    def project[A](fullPath: String)(
        innerSelection: SelectionBuilder[Project, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "project",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("fullPath", fullPath))
      )

    /**
      * Find Snippets visible to the current user
      */
    def snippets[A](
        after: Option[String] = None,
        authorId: Option[String] = None,
        before: Option[String] = None,
        explore: Option[Boolean] = None,
        first: Option[Int] = None,
        ids: Option[List[String]] = None,
        last: Option[Int] = None,
        projectId: Option[String] = None,
        `type`: Option[TypeEnum] = None,
        visibility: Option[VisibilityScopesEnum] = None
    )(
        innerSelection: SelectionBuilder[SnippetConnection, A]
    ): SelectionBuilder[RootQuery, Option[A]] =
      Field(
        "snippets",
        OptionOf(Obj(innerSelection)),
        arguments = List(
          Argument("after", after),
          Argument("authorId", authorId),
          Argument("before", before),
          Argument("explore", explore),
          Argument("first", first),
          Argument("ids", ids),
          Argument("last", last),
          Argument("projectId", projectId),
          Argument("type", `type`),
          Argument("visibility", visibility)
        )
      )
  }

  type Mutation = RootMutation
  object Mutation {
    def addAwardEmoji[A](input: AddAwardEmojiInput)(
        innerSelection: SelectionBuilder[AddAwardEmojiPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "addAwardEmoji",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def adminSidekiqQueuesDeleteJobs[A](
        input: AdminSidekiqQueuesDeleteJobsInput
    )(
        innerSelection: SelectionBuilder[AdminSidekiqQueuesDeleteJobsPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "adminSidekiqQueuesDeleteJobs",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def createDiffNote[A](input: CreateDiffNoteInput)(
        innerSelection: SelectionBuilder[CreateDiffNotePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "createDiffNote",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def createEpic[A](input: CreateEpicInput)(
        innerSelection: SelectionBuilder[CreateEpicPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "createEpic",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def createImageDiffNote[A](input: CreateImageDiffNoteInput)(
        innerSelection: SelectionBuilder[CreateImageDiffNotePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "createImageDiffNote",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def createNote[A](input: CreateNoteInput)(
        innerSelection: SelectionBuilder[CreateNotePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "createNote",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def createSnippet[A](input: CreateSnippetInput)(
        innerSelection: SelectionBuilder[CreateSnippetPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "createSnippet",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def designManagementDelete[A](input: DesignManagementDeleteInput)(
        innerSelection: SelectionBuilder[DesignManagementDeletePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "designManagementDelete",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def designManagementUpload[A](input: DesignManagementUploadInput)(
        innerSelection: SelectionBuilder[DesignManagementUploadPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "designManagementUpload",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def destroyNote[A](input: DestroyNoteInput)(
        innerSelection: SelectionBuilder[DestroyNotePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "destroyNote",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def destroySnippet[A](input: DestroySnippetInput)(
        innerSelection: SelectionBuilder[DestroySnippetPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "destroySnippet",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def epicAddIssue[A](input: EpicAddIssueInput)(
        innerSelection: SelectionBuilder[EpicAddIssuePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "epicAddIssue",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def epicSetSubscription[A](input: EpicSetSubscriptionInput)(
        innerSelection: SelectionBuilder[EpicSetSubscriptionPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "epicSetSubscription",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def epicTreeReorder[A](input: EpicTreeReorderInput)(
        innerSelection: SelectionBuilder[EpicTreeReorderPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "epicTreeReorder",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def issueSetConfidential[A](input: IssueSetConfidentialInput)(
        innerSelection: SelectionBuilder[IssueSetConfidentialPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "issueSetConfidential",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def issueSetDueDate[A](input: IssueSetDueDateInput)(
        innerSelection: SelectionBuilder[IssueSetDueDatePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "issueSetDueDate",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def issueSetWeight[A](input: IssueSetWeightInput)(
        innerSelection: SelectionBuilder[IssueSetWeightPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "issueSetWeight",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def markAsSpamSnippet[A](input: MarkAsSpamSnippetInput)(
        innerSelection: SelectionBuilder[MarkAsSpamSnippetPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "markAsSpamSnippet",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def mergeRequestSetAssignees[A](input: MergeRequestSetAssigneesInput)(
        innerSelection: SelectionBuilder[MergeRequestSetAssigneesPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "mergeRequestSetAssignees",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def mergeRequestSetLabels[A](input: MergeRequestSetLabelsInput)(
        innerSelection: SelectionBuilder[MergeRequestSetLabelsPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "mergeRequestSetLabels",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def mergeRequestSetLocked[A](input: MergeRequestSetLockedInput)(
        innerSelection: SelectionBuilder[MergeRequestSetLockedPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "mergeRequestSetLocked",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def mergeRequestSetMilestone[A](input: MergeRequestSetMilestoneInput)(
        innerSelection: SelectionBuilder[MergeRequestSetMilestonePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "mergeRequestSetMilestone",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def mergeRequestSetSubscription[A](input: MergeRequestSetSubscriptionInput)(
        innerSelection: SelectionBuilder[MergeRequestSetSubscriptionPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "mergeRequestSetSubscription",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def mergeRequestSetWip[A](input: MergeRequestSetWipInput)(
        innerSelection: SelectionBuilder[MergeRequestSetWipPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "mergeRequestSetWip",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def removeAwardEmoji[A](input: RemoveAwardEmojiInput)(
        innerSelection: SelectionBuilder[RemoveAwardEmojiPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "removeAwardEmoji",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def todoMarkDone[A](input: TodoMarkDoneInput)(
        innerSelection: SelectionBuilder[TodoMarkDonePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "todoMarkDone",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def todoRestore[A](input: TodoRestoreInput)(
        innerSelection: SelectionBuilder[TodoRestorePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "todoRestore",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def todoRestoreMany[A](input: TodoRestoreManyInput)(
        innerSelection: SelectionBuilder[TodoRestoreManyPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "todoRestoreMany",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def todosMarkAllDone[A](input: TodosMarkAllDoneInput)(
        innerSelection: SelectionBuilder[TodosMarkAllDonePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "todosMarkAllDone",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def toggleAwardEmoji[A](input: ToggleAwardEmojiInput)(
        innerSelection: SelectionBuilder[ToggleAwardEmojiPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "toggleAwardEmoji",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def updateEpic[A](input: UpdateEpicInput)(
        innerSelection: SelectionBuilder[UpdateEpicPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "updateEpic",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )

    /**
      * Updates a DiffNote on an image (a `Note` where the `position.positionType` is
`"image"`). If the body of the Note contains only quick actions, the Note will
be destroyed during the update, and no Note will be returned
      */
    def updateImageDiffNote[A](input: UpdateImageDiffNoteInput)(
        innerSelection: SelectionBuilder[UpdateImageDiffNotePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "updateImageDiffNote",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def updateIssue[A](input: UpdateIssueInput)(
        innerSelection: SelectionBuilder[UpdateIssuePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "updateIssue",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )

    /**
      * Updates a Note. If the body of the Note contains only quick actions, the Note
will be destroyed during the update, and no Note will be returned
      */
    def updateNote[A](input: UpdateNoteInput)(
        innerSelection: SelectionBuilder[UpdateNotePayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "updateNote",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
    def updateSnippet[A](input: UpdateSnippetInput)(
        innerSelection: SelectionBuilder[UpdateSnippetPayload, A]
    ): SelectionBuilder[RootMutation, Option[A]] =
      Field(
        "updateSnippet",
        OptionOf(Obj(innerSelection)),
        arguments = List(Argument("input", input))
      )
  }

}
